package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.DTOs.ClienteDTO;
import com.example.demo.DTOs.ClienteMapper;
import com.example.demo.model.Mascota;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;

    @GetMapping("/ver")
    public List<Cliente> mostrarClientes() {
        return service.findAll();
    }

    // http://localhost:8080/clientes/ver/{id}
    @GetMapping("/ver/{id}")
    public Cliente mostrarCliente(@PathVariable("id") Long identificacion) {
        return service.findById(identificacion);
    }

    // http://localhost:8080/clientes/ver/{id}
    @GetMapping("/cedula/{cedula}")
    public Cliente mostrarClienteByCedula(@PathVariable("cedula") int cedula) {
        return service.findByCedula(cedula);
    }

    // http://localhost:8080/clientes/login
    @PostMapping("/login")
    public ResponseEntity<String> loginClienteEntity(@RequestBody ClienteDTO clienteDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(clienteDTO.getCedula(), "123"));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<Cliente> buscarEstudianteEntity() {
        Cliente cliente = service.findByCedula(Integer.parseInt(
                SecurityContextHolder.getContext().getAuthentication().getName()));

        if (cliente == null) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    // http://localhost:8080/clientes/ver/{id}/mascotas
    @GetMapping("/ver/{id}/mascotas")
    public List<Mascota> mostrarMascotasCliente(@PathVariable("id") Long identificacion) {
        return mascotaService.findByDuenoId(identificacion);
    }

    // http://localhost:8080/clientes/agregar
    @GetMapping("/agregar")
    public String agregarCliente(Model model, @RequestParam("veterinarioId") Long veterinarioId) {
        Cliente cliente = new Cliente(0, "", "", 0);

        model.addAttribute("veterinarioId", veterinarioId);
        model.addAttribute("cliente", cliente);

        return "agregar_cliente";
    }

    // http://localhost:8080/clientes/agregar
    @PostMapping("/agregar")
    public ResponseEntity agregarCliente(@RequestBody Cliente cliente) {

        if (userRepository.existsByUsername(String.valueOf(cliente.getCedula()))) {
            return new ResponseEntity<String>("Este cliente ya existe", HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = customUserDetailService.ClienteToUser(cliente);
        cliente.setUser(userEntity);
        Cliente newCliente = service.add(cliente);
        if (newCliente == null) {
            return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Cliente>(newCliente, HttpStatus.CREATED);

    }

    // http://localhost:8080/clientes/eliminar/{id}
    @Transactional
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable("id") Long id) {
        Cliente cliente = service.findById(id);
        if (cliente == null) {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
        
        if (cliente.getUser() != null) {
            UserEntity user = cliente.getUser();
            user.getRoles().clear();
            userRepository.save(user); 
            userRepository.delete(user);
        }
        
        service.deleteById(id);
        return new ResponseEntity<>("Cliente eliminado exitosamente", HttpStatus.OK);
    }

    // http://localhost:8080/clientes/modificar/{id}
    @GetMapping("/modificar/{id}")
    public String modificarCliente(Model model, @PathVariable("id") Long identificacion,
            @RequestParam("veterinarioId") Long veterinarioId) {
        model.addAttribute("veterinarioId", veterinarioId);
        model.addAttribute("cliente", service.findById(identificacion));
        return "modificar_cliente";
    }

    // http://localhost:8080/clientes/modificar/{id}
    @PutMapping("/modificar")
    public void modificarCliente(@RequestBody Cliente cliente) {
        Cliente original = service.findById(cliente.getId());
        cliente.setMascotas(original.getMascotas());
        service.update(cliente);
    }
}
