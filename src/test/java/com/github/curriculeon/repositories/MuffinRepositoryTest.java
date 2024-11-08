package com.github.curriculeon.repositories;

import com.github.curriculeon.models.Baker;
import com.github.curriculeon.models.Muffin;
import com.github.curriculeon.services.BakerService;
import com.github.curriculeon.services.MuffinService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class MuffinRepositoryTest {

    @MockBean
    private MuffinRepository muffinRepository;

    private MuffinService muffinService;


    @Before
    public void setup(){
        muffinRepository =mock(MuffinRepository.class);
        muffinService =  new MuffinService(muffinRepository);
    }


    @Test
    public void testShowById() {
        Long muffinId = 1L;
        Muffin muffin = new Muffin();
        muffin.setId(muffinId);
        muffin.setFlavor("Vanilla");

        BDDMockito
                .given(muffinRepository.findById(muffinId))
                .willReturn(Optional.of(muffin));

        Muffin result = muffinService.show(muffinId);

        assertNotNull(result);
        assertEquals("Vanilla", result.getFlavor());

        Mockito.verify(muffinRepository, times(1)).findById(muffinId);
    }

    @Test
    public void testRepoSave() {
        Long muffinId = 1L;
        Muffin muffin = new Muffin();
        muffin.setId(muffinId);
        muffin.setFlavor("Chocolate");

        BDDMockito
                .given(muffinRepository.save(muffin))
                .willReturn(muffin);

        Muffin result = muffinService.create(muffin);
//
        assertNotNull(result);
        assertEquals("Chocolate", result.getFlavor());
//
        Mockito.verify(muffinRepository, times(1)).save(muffin);
    }
}
