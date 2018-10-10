package guru.springframework.controller;

import guru.springframework.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IndexControllerTest {

    IndexController controller;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {
        Model model = new ExtendedModelMap();
        String result = controller.getIndexPage(model);

        assertThat(result, is("index"));
        Map<String, Object> stringObjectMap = model.asMap();
        assertThat(stringObjectMap.containsKey("recipes"), is(true));
    }

    @Test
    public void sfgIndexPageTest() {

        String result = controller.getIndexPage(model);
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}