package th.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import th.database.service.ClientService;
import th.model.entities.Client;

@Component
public class ClientConverter implements Converter<String, Client> {

    @Autowired
    private ClientService clientService;

    @Override
    public Client convert(String id) {
        return clientService.findById(Integer.parseInt(id));
    }
}
