package com.example.demo.model;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ConsultaRepository;
import com.example.demo.repository.DrogaRepository;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VeterinarioRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
@Profile("default")
public class DataBaseinit implements ApplicationRunner {

        @Autowired
        ClienteRepository client_repo;

        @Autowired
        MascotaRepository mascota_repo;

        @Autowired
        VeterinarioRepository vet_repo;

        @Autowired
        DrogaRepository droga_repo;

        @Autowired
        ConsultaRepository consulta_repo;

        @Autowired
        PasswordEncoder passwordEncoder;

        @Autowired
        RoleRepository role_repo;

        @Autowired
        UserRepository user_repo;

        @Override
        public void run(ApplicationArguments args) throws Exception {

                role_repo.save(new Role("CLIENTE"));
                role_repo.save(new Role("VETERINARIO"));
                role_repo.save(new Role("ADMIN"));

                Cliente clienteSave;
                Veterinario veterinarioSave;
                UserEntity userEntity;
                UserEntity admin = new UserEntity();

                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("Jave1234*"));
                admin.getRoles().add(role_repo.findByName("ADMIN").get());
                userEntity = user_repo.save(admin);

                clienteSave = (new Cliente(123456, "Gabriel Mora", "morita@gmail.com", 896547));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(9876543, "Eladio Carrion", "ela.god@gmail.com", 546791));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(753124, "Benito Antonio", "BadBunny@gmail.com", 749685));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(741258, "Diomedes Diaz", "diomedesdays@gmail.com", 349761));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(852123, "Kaleth Morales", "KaLimbo@gmail.com", 412398));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(6523987, "Silvestre Dangond", "WinniePooh@gmail.com", 987201));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(12345678, "Henry Cavill", "cavillHenry@gmail.com", 321567885));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(456123, "Lana Del Rey", "lana.delrey@gmail.com", 658124));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(234567, "Rosalía Vila", "rosalia.vila@gmail.com", 321654));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(987654, "Sebastián Yatra", "yatra.sebas@gmail.com", 875412));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(654789, "Shakira Mebarak", "shaki@gmail.com", 963258));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(321654, "Rauw Alejandro", "rauw.alejandro@gmail.com", 784512));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(963852, "Karol G", "karolg@gmail.com", 654123));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(159753, "Nicky Jam", "nicky.jam@gmail.com", 258741));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(258741, "Marc Anthony", "marc.anthony@gmail.com", 951753));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(852369, "Maluma", "maluma.baby@gmail.com", 741852));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(753951, "J Balvin", "balvin.j@gmail.com", 852741));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(456852, "Ozuna", "ozuna@gmail.com", 369852));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(654321, "Daddy Yankee", "daddy.yankee@gmail.com", 789456));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(741852, "Anuel AA", "anuel.aa@gmail.com", 987654));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(987123, "Natti Natasha", "natti.natasha@gmail.com", 654789));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(789456, "Tini Stoessel", "tini@gmail.com", 456123));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(852741, "Becky G", "beckyg@gmail.com", 123789));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(369852, "Camila Cabello", "camila.cabello@gmail.com", 654321));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(963741, "Ricky Martin", "ricky.martin@gmail.com", 852963));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(753159, "Thalía", "thalia@gmail.com", 951357));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(6547891, "Enrique Iglesias", "enrique.iglesias@gmail.com", 159753));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(7412581, "Carlos Vives", "vives.carlos@gmail.com", 852963));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(8529631, "Juanes", "juanes@gmail.com", 753159));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(9513571, "Alejandro Sanz", "sanz.alejandro@gmail.com", 654852));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(1597531, "Pablo Alborán", "pablo.alboran@gmail.com", 321654));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(2589631, "Manuel Turizo", "turizo.manuel@gmail.com", 654789));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(456741, "Kany García", "kany.garcia@gmail.com", 852963));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(123789, "Gloria Trevi", "gloria.trevi@gmail.com", 159753));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(9874561, "David Bisbal", "david.bisbal@gmail.com", 753951));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(6549631, "Alejandra Guzmán", "alejandra.guzman@gmail.com", 369852));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(9517531, "Ricardo Arjona", "arjona@gmail.com", 963852));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(9638521, "Amanda Miguel", "amanda.miguel@gmail.com", 456741));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(3692581, "Eros Ramazzotti", "eros.ramazzotti@gmail.com", 654852));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(123123, "Selena Gomez", "selena.gomez@gmail.com", 789123));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(321321, "Justin Bieber", "justin.bieber@gmail.com", 654789));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(987987, "Ariana Grande", "ariana.grande@gmail.com", 852963));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(654654, "Taylor Swift", "taylor.swift@gmail.com", 963741));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(789789, "Shawn Mendes", "shawn.mendes@gmail.com", 159753));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(852852, "Billie Eilish", "billie.eilish@gmail.com", 258963));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(963963, "Dua Lipa", "dua.lipa@gmail.com", 369852));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(6543211, "João Gilberto", "joao.gilberto@gmail.com", 852741));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(7891231, "Zara Larsson", "zara.larsson@gmail.com", 654321));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(8529630, "Aitana", "aitana@gmail.com", 123456));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);
                clienteSave = (new Cliente(9632581, "Lali", "lali@gmail.com", 987654));
                userEntity = saveUserCliente(clienteSave);
                clienteSave.setUser(userEntity);
                client_repo.save(clienteSave);

                mascota_repo.save(new Mascota("Luna", "Beagle", 3, 10.5f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/1200px-Shemsu_Sotis_Perun.jpg",
                                "Dermatitis"));
                mascota_repo.save(new Mascota("Max", "Golden Retriever", 5, 25.3f,
                                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09golden20retriever.jpg?itok=48StbVfe",
                                "Displasia de cadera"));
                mascota_repo.save(new Mascota("Bella", "Bulldog Francés", 4, 12.7f,
                                "https://picartpetcare.com/wp-content/uploads/2020/05/BULLDOG-FRANC%C3%89S.jpg",
                                "Infección respiratoria"));
                mascota_repo.save(new Mascota("Charlie", "Labrador Retriever", 6, 30.2f,
                                "https://pamipe.com/wiki/wp-content/uploads/2022/09/Labrador-Retriever.jpg",
                                "Oído externo inflamado"));
                mascota_repo.save(new Mascota("Lucy", "Poodle", 2, 8.4f,
                                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQbIyCu-ZrIJlcLWxk9iYlL1ighFx-itgPbzp-VTG3Hma1EVy44",
                                "Alergia alimentaria"));
                mascota_repo.save(new Mascota("Rocky", "Boxer", 5, 28.9f,
                                "https://cdn.royalcanin-weshare-online.io/ZT-S7XoBRYZmsWpc4beN/v9/bp-lot-2-boxer-bw-ws-2",
                                "Cardiomiopatía"));
                mascota_repo.save(new Mascota("Daisy", "Cocker Spaniel", 3, 14.1f,
                                "https://blog-static.petlove.com.br/wp-content/uploads/2018/06/cocker-figado-tan.jpg",
                                "Otitis"));
                mascota_repo.save(new Mascota("Cooper", "Border Collie", 4, 20.0f,
                                "https://example.com/images/border_collie1.jpg", "Epilepsia"));
                mascota_repo.save(new Mascota("Molly", "Chihuahua", 3, 2.5f,
                                "https://example.com/images/chihuahua1.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Buddy", "Siberian Husky", 4, 22.8f,
                                "https://dogtime.com/wp-content/uploads/sites/12/2023/11/GettyImages-1454565264-e1701120522406.jpg",
                                "Alergia a la comida"));
                mascota_repo.save(new Mascota("Zoe", "Dachshund", 5, 9.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRa3ewvi6qjaUE5Z87OXoKlxqHu83Tc8u5bnA&s",
                                "Problemas de columna"));
                mascota_repo.save(new Mascota("Bailey", "Shih Tzu", 2, 7.4f,
                                "https://www.perro-obediente.com/blog/wp-content/uploads/2023/04/cachorro-shih-tzu-aislado-blanco_87557-18423.jpg",
                                "Conjuntivitis"));
                mascota_repo.save(new Mascota("Oliver", "Pomerania", 3, 3.2f,
                                "https://example.com/images/pomerania1.jpg", "Enfermedad periodontal"));
                mascota_repo.save(new Mascota("Sadie", "Bulldog Inglés", 4, 24.5f,
                                "https://example.com/images/bulldog_ingles1.jpg", "Dificultad para respirar"));
                mascota_repo.save(new Mascota("Toby", "Bichón Frisé", 5, 7.9f,
                                "https://blog.mascotaysalud.com/wp-content/uploads/2020/03/Bich%C3%B3n-Fris%C3%A9-rostro.jpg",
                                "Alergia cutánea"));
                mascota_repo.save(new Mascota("Sophie", "Pastor Alemán", 6, 28.7f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "Problemas en las articulaciones"));
                mascota_repo.save(new Mascota("Bear", "Rottweiler", 4, 45.2f,
                                "https://example.com/images/rottweiler1.jpg", "Displasia de cadera"));
                mascota_repo.save(new Mascota("Maggie", "Yorkshire Terrier", 3, 3.1f,
                                "https://media.graphassets.com/output=format:webp/KHpTY4nvQMiNxkgNcfNm",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Jack", "Pug", 5, 8.9f, "https://example.com/images/pug1.jpg",
                                "Ojos secos"));
                mascota_repo.save(new Mascota("Chloe", "Caniche", 4, 4.8f, "https://example.com/images/caniche1.jpg",
                                "Dermatitis alérgica"));
                mascota_repo.save(new Mascota("Duke", "Doberman", 5, 34.6f, "https://example.com/images/doberman1.jpg",
                                "Problemas cardíacos"));
                mascota_repo.save(new Mascota("Roxy", "Akita", 4, 32.7f, "https://example.com/images/akita1.jpg",
                                "Infección en la piel"));
                mascota_repo.save(new Mascota("Ruby", "Samoyedo", 4, 21.4f, "https://example.com/images/samoyedo1.jpg",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Oscar", "Mastín", 5, 50.3f, "https://example.com/images/mastin1.jpg",
                                "Displasia de cadera"));
                mascota_repo.save(new Mascota("Milo", "Pug", 3, 8.7f, "https://example.com/images/pug2.jpg",
                                "Problemas de piel"));
                mascota_repo.save(new Mascota("Rosie", "Chihuahua", 2, 2.3f,
                                "https://example.com/images/chihuahua2.jpg", "Cataratas"));
                mascota_repo.save(new Mascota("Lily", "Shih Tzu", 3, 7.2f,
                                "https://static.wixstatic.com/media/aa8751_1aa95fd67b9e4f13850e5de823d7fb5c~mv2.jpg/v1/fill/w_736,h_1000,al_c,q_85,enc_auto/aa8751_1aa95fd67b9e4f13850e5de823d7fb5c~mv2.jpg",
                                "Problemas en los ojos"));
                mascota_repo.save(new Mascota("Gus", "Beagle", 4, 11.0f,
                                "https://www.elmueble.com/medio/2023/03/02/perro-de-raza-beagle_67c65dda_230302133829_900x900.jpg",
                                "Infección en el oído"));
                mascota_repo.save(new Mascota("Bruno", "Labrador Retriever", 5, 30.8f,
                                "https://example.com/images/labrador2.jpg", "Displasia de cadera"));
                mascota_repo.save(new Mascota("Ellie", "Cocker Spaniel", 3, 14.5f,
                                "https://tierarzt-karlsruhe-durlach.de/storage/2024/04/Cocker-Spaniel-Krankheiten.webp",
                                "Infección ocular"));
                mascota_repo.save(new Mascota("Finn", "Border Collie", 4, 20.4f,
                                "https://example.com/images/border_collie2.jpg", "Alergias"));
                mascota_repo.save(new Mascota("Nala", "Boxer", 4, 27.9f,
                                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.ecured.cu%2FB%25C3%25B3xer&psig=AOvVaw3zA5cq7cClKyJcvuBSc8Ug&ust=1725056714519000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCJCa4Jqfm4gDFQAAAAAdAAAAABAR",
                                "Problemas en el corazón"));
                mascota_repo.save(new Mascota("Louie", "Pomerania", 2, 3.4f,
                                "https://example.com/images/pomerania2.jpg", "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Mia", "Yorkshire Terrier", 4, 3.6f,
                                "https://example.com/images/yorkshire_terrier1.jpg", "Cataratas"));
                mascota_repo.save(new Mascota("Bear", "Golden Retriever", 6, 32.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyVeJ8Ko5FZoxS58WMCwRoVjNKrfiZTC5bBQ&usqp=CAU",
                                "Problemas en las articulaciones"));
                mascota_repo.save(new Mascota("Lucy", "Chihuahua", 3, 2.2f, "https://example.com/images/chihuahua3.jpg",
                                "Problemas dentales"));
                mascota_repo.save(new Mascota("Zoe", "Poodle", 2, 6.5f,
                                "https://www.dondemiveterinario.com/wp-content/uploads/2022/10/poodle-estandar-principal.jpg",
                                "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Rocky", "Beagle", 4, 10.8f,
                                "https://t1.uc.ltmcdn.com/es/posts/9/3/9/caracteristicas_fisicas_del_beagle_50939_1_600.jpg",
                                "Problemas en la piel"));
                mascota_repo.save(new Mascota("Sophie", "Dachshund", 5, 9.1f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRm_lSuPfR0FIkU8bP7W7O97pylK6Wyupzq8K-TpYw&iTHyPvCEyw&usqp=CAU",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Charlie", "Boxer", 4, 27.5f, "https://example.com/images/boxer2.jpg",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Maggie", "Shih Tzu", 3, 8.2f, "https://example.com/images/shih_tzu2.jpg",
                                "Infección en la piel"));
                mascota_repo.save(new Mascota("Rosie", "Dachshund", 5, 10.2f,
                                "https://example.com/images/dachshund2.jpg", "Problemas digestivos"));
                mascota_repo.save(new Mascota("Roxy", "Cocker Spaniel", 4, 15.4f,
                                "https://example.com/images/cocker_spaniel2.jpg", "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Lily", "Shih Tzu", 2, 6.0f, "https://example.com/images/shih_tzu3.jpg",
                                "Infección ocular"));
                mascota_repo.save(new Mascota("Finn", "Yorkshire Terrier", 5, 4.2f,
                                "https://example.com/images/yorkshire_terrier2.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Bella", "Siberian Husky", 6, 25.6f,
                                "https://www.anicura.es/cdn-cgi/image/f=auto,q=60,fit=cover,w=1536,h=1152,g=auto,sharpen=1/AdaptiveImages/powerinit/15458/Print_AniCura_Dogs_352_Siberian%20husky.jpg?stamp=9cee4d21ea154efc36aa55248d02fa894a93c10e",
                                "Problemas en las articulaciones"));
                mascota_repo.save(new Mascota("Buddy", "Beagle", 2, 9.5f,
                                "https://hips.hearstapps.com/hmg-prod/images/beagle-dog-breed-66697acf1e1b8.jpg?crop=0.893xw:1.00xh;0.0554xw,0&resize=768:*",
                                "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Jack", "Pug", 3, 8.2f, "https://example.com/images/pug3.jpg",
                                "Problemas articulares"));
                mascota_repo.save(new Mascota("Nala", "Shih Tzu", 4, 7.5f, "https://example.com/images/shih_tzu4.jpg",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Milu", "Poodle", 3, 6.8f,
                                "https://petshopchicureo.cl/cdn/shop/articles/corte-poodle.jpg?v=1697614213",
                                "Alergia a la comida"));
                mascota_repo.save(new Mascota("Oscar", "Yorkshire Terrier", 5, 3.0f,
                                "https://example.com/images/yorkshire_terrier3.jpg", "Infección en la piel"));
                mascota_repo.save(new Mascota("Sophie", "Cocker Spaniel", 6, 15.2f,
                                "https://example.com/images/cocker_spaniel3.jpg", "Problemas en los ojos"));
                mascota_repo.save(new Mascota("Mia", "Beagle", 3, 10.9f,
                                "https://images.ctfassets.net/denf86kkcx7r/6zcaK24BXlretJmpcHIHUK/f7a6008d468fc13b5b7cd1591972057c/pexelsartembeliaikin4084420-2",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Rocky", "Boxer", 4, 29.3f, "https://example.com/images/boxer3.jpg",
                                "Enfermedad cardíaca"));
                mascota_repo.save(new Mascota("Toby", "Dachshund", 3, 9.5f, "https://example.com/images/dachshund3.jpg",
                                "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Rosie", "Shih Tzu", 4, 8.2f, "https://example.com/images/shih_tzu5.jpg",
                                "Problemas de piel"));
                mascota_repo.save(new Mascota("Finn", "Pomerania", 2, 3.6f, "https://example.com/images/pomerania5.jpg",
                                "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Lily", "Siberian Husky", 3, 24.8f,
                                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-08Siberian20Husky2.jpg?itok=d5njFuxB",
                                "Problemas articulares"));
                mascota_repo.save(new Mascota("Bella", "Labrador Retriever", 5, 33.2f,
                                "https://example.com/images/labrador_retriever3.jpg", "Problemas en la piel"));
                mascota_repo.save(new Mascota("Zoe", "Golden Retriever", 4, 30.5f,
                                "https://example.com/images/golden_retriever4.jpg", "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Maggie", "Border Collie", 3, 18.0f,
                                "https://example.com/images/border_collie3.jpg", "Problemas en los ojos"));
                mascota_repo.save(new Mascota("Lenda", "Poodle", 4, 6.5f,
                                "https://lenda.net/wp-content/uploads/2023/12/Un-perro-poodle-feliz-jpg.webp",
                                "Alergia alimentaria"));
                mascota_repo.save(new Mascota("Oscar", "Beagle", 10, 11.5f,
                                "https://thumbs.dreamstime.com/b/un-perro-viejo-del-beagle-16953148.jpg",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Buddy", "Siberian Husky", 4, 22.0f,
                                "https://images.saymedia-content.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cq_auto:eco%2Cw_1200/MTk2Njc0ODUxNzAyODQzMTk4/colors-of-siberian-huskies.png",
                                "Alergia a la comida"));
                mascota_repo.save(new Mascota("Roxy", "Pug", 3, 7.8f, "https://example.com/images/pug4.jpg",
                                "Problemas de piel"));
                mascota_repo.save(new Mascota("Nala", "Dachshund", 4, 9.0f, "https://example.com/images/dachshund4.jpg",
                                "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Rosie", "Cocker Spaniel", 6, 16.0f,
                                "https://example.com/images/cocker_spaniel4.jpg", "Problemas de piel"));
                mascota_repo.save(new Mascota("Gus", "Shih Tzu", 5, 7.7f, "https://example.com/images/shih_tzu6.jpg",
                                "Problemas dentales"));
                mascota_repo.save(new Mascota("Lily", "Pomerania", 3, 3.0f, "https://example.com/images/pomerania6.jpg",
                                "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Rosie", "Border Collie", 4, 21.5f,
                                "https://example.com/images/border_collie4.jpg", "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Oscar", "Pug", 5, 9.0f, "https://example.com/images/pug5.jpg",
                                "Enfermedad cardíaca"));
                mascota_repo.save(new Mascota("Roxy", "Pomerania", 3, 3.2f, "https://example.com/images/pomerania7.jpg",
                                "Problemas articulares"));
                mascota_repo.save(new Mascota("Maggie", "Siberian Husky", 3, 26.0f,
                                "https://plus.unsplash.com/premium_photo-1668208363137-7ebc4ce6b7b7?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8c2liZXJpYW4lMjBodXNreXxlbnwwfHwwfHx8MA%3D%3D",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Mia", "Yorkshire Terrier", 2, 3.4f,
                                "https://example.com/images/yorkshire_terrier4.jpg", "Enfermedad de piel"));
                mascota_repo.save(new Mascota("Toby", "Labrador Retriever", 5, 32.0f,
                                "https://example.com/images/labrador_retriever4.jpg", "Problemas articulares"));
                mascota_repo.save(new Mascota("Finn", "Shih Tzu", 4, 7.8f, "https://example.com/images/shih_tzu7.jpg",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Sophie", "Pomerania", 2, 3.6f,
                                "https://example.com/images/pomerania8.jpg", "Alergias respiratorias"));
                mascota_repo.save(new Mascota("Rosie", "Golden Retriever", 4, 31.5f,
                                "https://example.com/images/golden_retriever5.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Gus", "Pug", 5, 8.4f, "https://example.com/images/pug6.jpg",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Buddy", "Shih Tzu", 4, 6.9f, "https://example.com/images/shih_tzu8.jpg",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Bella", "Cocker Spaniel", 5, 14.0f,
                                "https://example.com/images/cocker_spaniel5.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Max", "Labrador Retriever", 3, 29.4f,
                                "https://example.com/images/labrador_retriever5.jpg", "Infección en la piel"));
                mascota_repo.save(new Mascota("Sanzon", "Beagle", 1, 11.3f,
                                "https://www.publico.es/yo-animal/wp-content/uploads/2024/04/puppy-1024x687.jpg",
                                "Problemas articulares"));
                mascota_repo.save(new Mascota("Nala", "Pug", 5, 7.9f, "https://example.com/images/pug7.jpg",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Maggie", "Golden Retriever", 4, 30.0f,
                                "https://example.com/images/golden_retriever6.jpg", "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Oscar", "Shih Tzu", 6, 7.1f, "https://example.com/images/shih_tzu9.jpg",
                                "Enfermedad de piel"));
                mascota_repo.save(new Mascota("Roxy", "Beagle", 3, 10.9f,
                                "https://www.thesprucepets.com/thmb/slg48hln7ejv_3XYrcdLG8ooKwE=/2119x0/filters:no_upscale():strip_icc()/GettyImages-475324140-292c4ecfd73c4c8483efe31193f8189a.jpg",
                                "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Sophie", "Pomerania", 4, 3.5f,
                                "https://example.com/images/pomerania9.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Finn", "Siberian Husky", 2, 26.5f,
                                "https://huskysiberiano.cl/wp-content/uploads/2023/11/cuidado-husky.jpg",
                                "Alergias respiratorias"));
                mascota_repo.save(new Mascota("Mia", "Labrador Retriever", 4, 33.0f,
                                "https://example.com/images/labrador_retriever6.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Toby", "Pug", 3, 7.6f, "https://example.com/images/pug8.jpg",
                                "Infección ocular"));
                mascota_repo.save(new Mascota("Rosie", "Pomerania", 2, 3.7f,
                                "https://example.com/images/pomerania10.jpg", "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Gus", "Beagle", 5, 11.1f,
                                "https://espree.com/sites/default/files/2019-10/Beagle.png",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Sophie", "Golden Retriever", 4, 32.5f,
                                "https://example.com/images/golden_retriever7.jpg", "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Max", "Boxer", 4, 27.8f, "https://example.com/images/boxer4.jpg",
                                "Problemas en los ojos"));
                mascota_repo.save(new Mascota("Maggie", "Dachshund", 3, 9.7f,
                                "https://example.com/images/dachshund5.jpg", "Infección en la piel"));
                mascota_repo.save(new Mascota("Rosie", "Poodle", 6, 6.2f,
                                "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2023/02/09141023/Diana-the-Poodle.jpg",
                                "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Mirio", "Siberian Husky", 5, 25.0f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGeoYzAkyO3wXe-MM_WYuxop9HeLIJMiMEuQ&s",
                                "Problemas articulares"));
                mascota_repo.save(new Mascota("Nala", "Golden Retriever", 4, 31.7f,
                                "https://example.com/images/golden_retriever8.jpg", "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Toby", "Pug", 3, 7.2f, "https://example.com/images/pug9.jpg",
                                "Problemas en los ojos"));
                mascota_repo.save(new Mascota("Finn", "Shih Tzu", 4, 7.4f, "https://example.com/images/shih_tzu11.jpg",
                                "Enfermedad de piel"));
                mascota_repo.save(new Mascota("Mia", "Yorkshire Terrier", 2, 3.5f,
                                "https://example.com/images/yorkshire_terrier6.jpg", "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Daisy", "Labrador Retriever", 3, 31.2f,
                                "https://example.com/images/labrador_retriever7.jpg", "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Rosie", "Pomerania", 5, 3.8f,
                                "https://example.com/images/pomerania11.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Mazorca", "Siberian Husky", 4, 24.0f,
                                "https://as2.ftcdn.net/v2/jpg/02/35/86/35/1000_F_235863557_Gc9FFamRiBXkZbO7nhQs5g3ce1Jwck8j.jpg",
                                "Alergias respiratorias"));
                mascota_repo.save(new Mascota("Maggie", "Dachshund", 6, 9.2f,
                                "https://example.com/images/dachshund6.jpg", "Problemas digestivos"));
                mascota_repo.save(new Mascota("Nala", "Beagle", 4, 11.2f,
                                "https://hips.hearstapps.com/hmg-prod/images/gettyimages-1437033396-65aa13023a8ed.jpg?crop=1xw:0.84375xh;center,top",
                                "Problemas en los ojos"));
                mascota_repo.save(new Mascota("Pardo", "Poodle", 5, 6.1f,
                                "https://preview.redd.it/mgm1808ede8b1.jpg?auto=webp&s=c424a1081cd95172ca64add0d61309cc4ae0eb9d",
                                "Enfermedad de piel"));
                mascota_repo.save(new Mascota("Rosie", "Pug", 3, 7.3f, "https://example.com/images/pug10.jpg",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Gus", "Cocker Spaniel", 4, 14.0f,
                                "https://example.com/images/cocker_spaniel6.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Toby", "Labrador Retriever", 5, 33.1f,
                                "https://example.com/images/labrador_retriever8.jpg", "Problemas articulares"));
                mascota_repo.save(new Mascota("Finn", "Yorkshire Terrier", 2, 3.8f,
                                "https://example.com/images/yorkshire_terrier7.jpg", "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Maggie", "Pomerania", 4, 3.7f,
                                "https://example.com/images/pomerania12.jpg", "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Rosie", "Shih Tzu", 5, 6.7f, "https://example.com/images/shih_tzu12.jpg",
                                "Problemas respiratorios"));

                veterinarioSave = (Veterinario.builder()
                                .nombre("Dr. Juan Perez")
                                .cedula(111111)
                                .clave("clave123")
                                .especialidad("Cirugía")
                                .fotoURL("https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.width-1200.format-webp.webp")
                                .estado(true)
                                .build());

                userEntity = saveUserVet(veterinarioSave);
                veterinarioSave.setUser(userEntity);
                vet_repo.save(veterinarioSave);

                veterinarioSave = (Veterinario.builder().nombre("Dra. Ana Gómez")
                                .cedula(222222)
                                .clave("clave234")
                                .especialidad("Medicina Interna")
                                .fotoURL("https://www.infobae.com/new-resizer/ZnDkR1HUD3VOYyxcl1NfySwaToc=/1440x960/filters:format(webp):quality(85)/cloudfront-us-east-1.images.arcpublishing.com/infobae/L6GI2ZSXFZGADESR57UO666ZE4.jpg")
                                .estado(true)
                                .build());

                userEntity = saveUserVet(veterinarioSave);
                veterinarioSave.setUser(userEntity);
                vet_repo.save(veterinarioSave);

                veterinarioSave = (Veterinario.builder()
                                .nombre("Dr. Carlos López")
                                .cedula(333333)
                                .clave("clave345")
                                .especialidad("Dermatología")
                                .fotoURL("https://blog.agrovetmarket.com/wp-content/uploads/2020/05/vet.jpg")
                                .estado(true)
                                .build());

                userEntity = saveUserVet(veterinarioSave);
                veterinarioSave.setUser(userEntity);
                vet_repo.save(veterinarioSave);

                veterinarioSave = (Veterinario.builder()
                                .nombre("Dra. Laura Martínez")
                                .cedula(444444)
                                .clave("clave456")
                                .especialidad("Odontología")
                                .fotoURL("https://bensvet.com.br/wp-content/uploads/2020/03/blog-5-passos-para-se-tornar-o-melhor-m%C3%A9dico-veterin%C3%A1rio.jpg")
                                .estado(true)
                                .build());

                userEntity = saveUserVet(veterinarioSave);
                veterinarioSave.setUser(userEntity);
                vet_repo.save(veterinarioSave);

                veterinarioSave = (Veterinario.builder()
                                .nombre("Dr. Andrés Fernández")
                                .cedula(555555)
                                .clave("clave567")
                                .especialidad("Cardiología")
                                .fotoURL("https://media.diariolasamericas.com/p/dd615822f3890b61f37609e2635dd657/adjuntos/216/imagenes/100/128/0100128714/1200x630/smart/dia-mundial-del-veterinariojpg.jpg")
                                .estado(true)
                                .build());

                userEntity = saveUserVet(veterinarioSave);
                veterinarioSave.setUser(userEntity);
                vet_repo.save(veterinarioSave);

                veterinarioSave = (Veterinario.builder()
                                .nombre("Dra. Patricia Ruiz")
                                .cedula(666666)
                                .clave("clave678")
                                .especialidad("Neurología")
                                .fotoURL("https://blog.comparasoftware.com/wp-content/uploads/2022/02/software-veterinario-768x480.jpg")
                                .estado(true)
                                .build());

                userEntity = saveUserVet(veterinarioSave);
                veterinarioSave.setUser(userEntity);
                vet_repo.save(veterinarioSave);

                veterinarioSave = (Veterinario.builder()
                                .nombre("Dr. Javier Morales")
                                .cedula(777777)
                                .clave("clave789")
                                .especialidad("Oftalmología")
                                .fotoURL("https://plus.unsplash.com/premium_photo-1677165483776-3e2e85595746?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8dmV0ZXJpbmFyaWF8ZW58MHx8MHx8fDA%3D")
                                .estado(true)
                                .build());

                userEntity = saveUserVet(veterinarioSave);
                veterinarioSave.setUser(userEntity);
                vet_repo.save(veterinarioSave);

                veterinarioSave = (Veterinario.builder()
                                .nombre("Dra. Beatriz García")
                                .cedula(888888)
                                .clave("clave890")
                                .especialidad("Oncología")
                                .fotoURL("https://blog.uchceu.es/veterinaria/wp-content/uploads/sites/12/2012/07/293887-500x480.jpg")
                                .estado(true)
                                .build());

                userEntity = saveUserVet(veterinarioSave);
                veterinarioSave.setUser(userEntity);
                vet_repo.save(veterinarioSave);

                veterinarioSave = (Veterinario.builder()
                                .nombre("Dr. Mario Torres")
                                .cedula(999999)
                                .clave("clave901")
                                .especialidad("Gastroenterología")
                                .fotoURL("https://www.veterinariaelbosque.cl/images/noti_petcovid_3.jpg")
                                .estado(true)
                                .build());

                userEntity = saveUserVet(veterinarioSave);
                veterinarioSave.setUser(userEntity);
                vet_repo.save(veterinarioSave);

                veterinarioSave = (Veterinario.builder()
                                .nombre("Dra. Claudia Sánchez")
                                .cedula(101010)
                                .clave("clave1234")
                                .especialidad("Pediatría")
                                .fotoURL("https://bogota.gov.co/sites/default/files/styles/1050px/public/2024-05/vertinario-1.jpg")
                                .estado(true)
                                .build());

                userEntity = saveUserVet(veterinarioSave);
                veterinarioSave.setUser(userEntity);
                vet_repo.save(veterinarioSave);

                // Ruta al archivo Excel
                InputStream inputStream = getClass().getResourceAsStream("/static/excel/MEDICAMENTOS_VETERINARIA.xlsx");

                // Leer el archivo Excel
                Workbook workbook = new XSSFWorkbook(inputStream);
                Sheet sheet = workbook.getSheetAt(0); // Leer la primera hoja

                // Iterar sobre las filas del archivo
                Iterator<Row> rows = sheet.iterator();

                while (rows.hasNext()) {
                        Row row = rows.next();

                        // Suponiendo que la primera fila contiene encabezados
                        if (row.getRowNum() == 0) {
                                continue; // Omitir encabezados
                        }

                        // Suponiendo que el archivo tiene las columnas: nombre, dosis, descripción,
                        // etc.
                        String nombre = row.getCell(0).getStringCellValue();
                        double precioVenta = row.getCell(1).getNumericCellValue();
                        double precioCompra = row.getCell(2).getNumericCellValue();
                        int unidadesDisponibles = (int) row.getCell(3).getNumericCellValue();
                        int unidadesVendidas = (int) row.getCell(4).getNumericCellValue();
                        // Otros campos que puedas tener...

                        // Crear una nueva instancia de Droga
                        Droga droga = new Droga();
                        droga.setNombre(nombre);
                        droga.setPrecioVenta(precioVenta);
                        droga.setPrecioCompra(precioCompra);
                        droga.setUnidadesDisponibles(unidadesDisponibles);
                        droga.setUnidadesVendidas(unidadesVendidas);
                        // Asignar otros campos...

                        // Guardar el medicamento en la base de datos
                        droga_repo.save(droga);
                }

                // Cerrar el workbook y el InputStream
                workbook.close();
                inputStream.close();

                // Asociar mascotas a clientes
                List<Mascota> mascotas = mascota_repo.findAll();
                List<Cliente> clientes = client_repo.findAll();

                int indiceMascota = 0;
                for (Cliente cliente : clientes) {
                        for (int i = 0; i < 2 && indiceMascota < mascotas.size(); i++) {
                                Mascota mascota = mascotas.get(indiceMascota);
                                mascota.setCliente(cliente);
                                mascota_repo.save(mascota);
                                indiceMascota++;
                        }
                }

                Calendar calendar = Calendar.getInstance();

                calendar.set(2023, Calendar.MAY, 10);
                consulta_repo.save(new Consulta(calendar.getTime()));

                calendar.set(2023, Calendar.JUNE, 15);
                consulta_repo.save(new Consulta(calendar.getTime()));

                calendar.set(2024, Calendar.SEPTEMBER, 23);
                consulta_repo.save(new Consulta(calendar.getTime()));

                calendar.set(2023, Calendar.AUGUST, 25);
                consulta_repo.save(new Consulta(calendar.getTime()));

                calendar.set(2024, Calendar.SEPTEMBER, 30);
                consulta_repo.save(new Consulta(calendar.getTime()));

                calendar.set(2023, Calendar.OCTOBER, 5);
                consulta_repo.save(new Consulta(calendar.getTime()));

                calendar.set(2023, Calendar.NOVEMBER, 10);
                consulta_repo.save(new Consulta(calendar.getTime()));

                calendar.set(2023, Calendar.DECEMBER, 15);
                consulta_repo.save(new Consulta(calendar.getTime()));

                calendar.set(2024, Calendar.SEPTEMBER, 20);
                consulta_repo.save(new Consulta(calendar.getTime()));

                calendar.set(2024, Calendar.FEBRUARY, 25);
                consulta_repo.save(new Consulta(calendar.getTime()));

                int cantidad_mascota = mascota_repo.findAll().size();
                int cantidad_vet = vet_repo.findAll().size();
                int cantidad_droga = droga_repo.findAll().size();

                for (Consulta consulta : consulta_repo.findAll()) {
                        int mascota_id = ThreadLocalRandom.current().nextInt(1, cantidad_mascota);
                        int vet_id = ThreadLocalRandom.current().nextInt(1, cantidad_vet);
                        int droga_id = ThreadLocalRandom.current().nextInt(1, cantidad_droga);
                        int cantidad = ThreadLocalRandom.current().nextInt(1, 10);

                        Mascota mascota = mascota_repo.findById(Long.valueOf(mascota_id)).get();
                        Veterinario vet = vet_repo.findById(Long.valueOf(vet_id)).get();
                        Droga droga = droga_repo.findById(Long.valueOf(droga_id)).get();

                        consulta.setMascota(mascota);
                        consulta.setVeterinario(vet);
                        consulta.setDroga(droga);
                        consulta.setCantidad(cantidad);
                }
        }

        private UserEntity saveUserCliente(Cliente cliente) {
                UserEntity user = new UserEntity();
                user.setUsername(String.valueOf(cliente.getCedula()));
                user.setPassword(passwordEncoder.encode("123"));
                Role roles = role_repo.findByName("CLIENTE").get();
                user.setRoles(List.of(roles));
                return user_repo.save(user);
        }

        private UserEntity saveUserVet(Veterinario vet) {
                UserEntity user = new UserEntity();
                user.setUsername(String.valueOf(vet.getCedula()));
                user.setPassword(passwordEncoder.encode(vet.getClave()));
                Role roles = role_repo.findByName("VETERINARIO").get();
                user.setRoles(List.of(roles));
                return user_repo.save(user);
        }
}