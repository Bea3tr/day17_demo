package ssf.day17_demo.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.util.Date;

@RestController
@RequestMapping
public class TimeController {

    // POST /customer
    // Content-Type: application/x-www-form-urlencoded
    // Accept: text/html
    @PostMapping(path="/customer", produces = MediaType.TEXT_HTML_VALUE
        , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> postCustomerForm(@RequestBody MultiValueMap<String, String> form) {
        
        System.out.printf(">>> FORM: %s\n", form);

        String html = "<h3>%s has been registered</h3>".formatted(form.getFirst("name"));

        return ResponseEntity.ok(html);
    }


    // POST /customer
    // Content-Type: application/json
    // Accept: application/json
    @PostMapping(path="/customer", produces = MediaType.APPLICATION_JSON_VALUE
        , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postCustomer(@RequestBody String payload) {
        
        System.out.printf(">>> PAYLOAD: %s\n", payload);

        // 202 Accepted
        // Content-Type: application/json
        // \r\n
        // {}
        return ResponseEntity.accepted()
                .header("X-Myheader", "abc123")
                .body("{}");
    }

    // GET /time
    // Accept: application/json
    @GetMapping(path="/time", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTime() {

        /*
         * {"time": "a time"}
         */
        
        JsonObject resp = Json.createObjectBuilder()
            .add("time", (new Date()).toString())
            .build();

        // 200 OK
        // Content-type: application/json

        /*
         * ResponseEntity.status(200)
         *               .contentType(MediaType.APPLICATION_JSON)
         *               .body(resp.toString());
         */

        return ResponseEntity.ok(resp.toString());

        // return ResponseEntity.ok(new Time((new Date()).toString()))
    }

    @GetMapping(path="/time", produces = "text/plain")
    public String getTimeText() {
        // returns plain text
        return "Time: " + (new Date()).toString();
    }
    
    
}
