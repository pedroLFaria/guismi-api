package sistema;

import kikaha.core.test.KikahaRunner;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(KikahaRunner.class)
public class SistemaResourceTest {
    @Inject SistemaResource resource;

    @Test
    public void testFindSistema(){
        val getResponse = resource.findSistema();
        val entitySistema = (Sistema)getResponse.entity();
        assert !entitySistema.getCaminhos().isEmpty();
        assert !entitySistema.getCidades().isEmpty();
        assert !entitySistema.getDescendencias().isEmpty();
        assert !entitySistema.getHabilidades().isEmpty();
        assert !entitySistema.getHabitos().isEmpty();
        assert !entitySistema.getIdiomas().isEmpty();
        assert !entitySistema.getRacas().isEmpty();
        assert !entitySistema.getPatronos().isEmpty();
    }
}
