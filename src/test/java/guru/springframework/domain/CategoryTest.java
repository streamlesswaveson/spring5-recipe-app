package guru.springframework.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {
    Category category;

    @Before
    public void before() {

        category = new Category();

    }

    @Test
    public void getId() {
        Long foo = 1l;

        category.setId(foo);
        assertEquals(foo, category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}