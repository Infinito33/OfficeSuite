package th.database.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import th.database.dto.PolisazycieDto;
import th.model.entities.Polisazycie;

/**
 * DTO mapper for {@link th.model.entities.Polisazycie} entity class.
 *
 * @author tomasz.huchro, 2016-09-03.
 * @version 1.0
 */
@Component
public class PolisazycieMapper extends ConfigurableMapper {

    private static final Logger LOG = Logger.getLogger(PolisazycieMapper.class.getName());

    public PolisazycieMapper() {
        LOG.info("Polisazycie mapper created.");
    }

    @Override
    protected void configure(MapperFactory factory) {
        factory.registerClassMap(
                factory.classMap(Polisazycie.class, PolisazycieDto.class)
                        .field("client.name", "clientName")
                        .field("client.lastname", "clientLastname")
                        .byDefault().toClassMap());
    }

    public List<PolisazycieDto> getPolisazycieDtoList(
            List<Polisazycie> polisazycieList) {
        List<PolisazycieDto> polisazycieDtoList = new ArrayList<>();

        for (Polisazycie polisazycie : polisazycieList) {
            polisazycieDtoList.add(getPolisazycieDto(polisazycie));
        }
        return polisazycieDtoList;
    }

    public PolisazycieDto getPolisazycieDto(Polisazycie polisazycie) {
        PolisazycieDto polisazycieDto = new PolisazycieDto();
        map(polisazycie, polisazycieDto);
        return polisazycieDto;
    }

    public Polisazycie getPolisazycie(PolisazycieDto polisazycieDto) {
        Polisazycie polisazycie = new Polisazycie();
        map(polisazycieDto, polisazycie);
        return polisazycie;
    }

}