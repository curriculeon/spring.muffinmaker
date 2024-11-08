package com.github.curriculeon.repositories;

import com.github.curriculeon.controllers.BakerController;
import com.github.curriculeon.models.Baker;
import com.github.curriculeon.services.BakerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class BakerRepositoryTest {

    @MockBean
        private BakerRepository bakerRepository;

        private BakerService bakerService;


    @Before
    public void setup(){
        bakerRepository =mock(BakerRepository.class);
        bakerService =  new BakerService(bakerRepository);
    }


        @Test
        public void testShowById() {
            Long bakerId = 1L;
            Baker baker = new Baker();
            baker.setId(bakerId);
            baker.setName("John Baker");

            BDDMockito
                    .given(bakerRepository.findById(bakerId))
                    .willReturn(Optional.of(baker));

            Baker result = bakerService.show(bakerId);

            assertNotNull(result);
            assertEquals("John Baker", result.getName());

            Mockito.verify(bakerRepository, times(1)).findById(bakerId);
        }

    @Test
    public void testRepoSave() {
        Long bakerId = 1L;
        Baker baker = new Baker();
        baker.setId(bakerId);
        baker.setName("John Baker");

        BDDMockito
                .given(bakerRepository.save(baker))
                .willReturn(baker);

        Baker result = bakerService.create(baker);
//
        assertNotNull(result);
        assertEquals("John Baker", result.getName());
//
        Mockito.verify(bakerRepository, times(1)).save(baker);
    }
    }

