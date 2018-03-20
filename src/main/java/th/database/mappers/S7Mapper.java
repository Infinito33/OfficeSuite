package th.database.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import th.database.dto.S7Dto;
import th.model.entities.S7;

/**
 * DTO mapper for {@link th.model.entities.S7} entity class.
 *
 * @author tomasz.huchro, 2016-09-03.
 * @version 1.0
 */
@Component
public class S7Mapper extends ConfigurableMapper {

    private static final Logger LOG = Logger.getLogger(S7Mapper.class.getName());

    public S7Mapper() {
        LOG.info("S7 mapper created.");
    }

    @Override
    protected void configure(MapperFactory factory) {
        factory.registerClassMap(
                factory.classMap(S7.class, S7Dto.class)
                        .field("client.name", "clientName")
                        .field("client.lastname", "clientLastname")
                        .byDefault().toClassMap());
    }

    public List<S7Dto> getS7DtoList(List<S7> s7List) {
        List<S7Dto> s7DtoList = new ArrayList<>();

        for (S7 s7 : s7List) {
            s7DtoList.add(getS7Dto(s7));
        }

        return s7DtoList;
    }

    public S7Dto getS7Dto(S7 s7) {
        S7Dto s7Dto = new S7Dto();
        map(s7, s7Dto);
        return s7Dto;
    }
}