package bzh.zomzog.demo.openapispringclienttoken.back.controller;

import bzh.zomzog.demo.openapispringclienttoken.controller.api.PoniesApi;
import bzh.zomzog.demo.openapispringclienttoken.domain.api.Pony;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static java.util.Collections.singletonList;

@RestController
public class PoniesController implements PoniesApi {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseEntity<List<Pony>> _list(@Valid String name) {
        log.info("List ponies");

        return ResponseEntity.ok(singletonList(new Pony().name("Rainbow Dash")));
    }


}