package bzh.zomzog.demo.openapispringclienttoken.front.controller;

import bzh.zomzog.demo.openapispringclienttoken.front.controller.api.PoniesApi;
import bzh.zomzog.demo.openapispringclienttoken.front.domain.api.Pony;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/front/ponies")
@AllArgsConstructor
public class DemoController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PoniesApi poniesApi;

    @GetMapping
    public ResponseEntity<List<Pony>> list() {
        log.info("List ponies");
        final List<Pony> list = poniesApi.list(null);
        return ResponseEntity.ok(list);

    }

}
