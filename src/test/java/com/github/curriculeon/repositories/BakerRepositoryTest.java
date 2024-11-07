package com.github.curriculeon.repositories;

import com.github.curriculeon.models.Baker;
import com.github.curriculeon.services.BakerService;
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


        private BakerRepository bakerRepository = mock(BakerRepository.class);

        private BakerService bakerService= new BakerService(bakerRepository);


        @Test
        public void testCreate() {
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
    }

