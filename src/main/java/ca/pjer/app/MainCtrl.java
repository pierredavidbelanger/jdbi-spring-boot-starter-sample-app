package ca.pjer.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@RestController
public class MainCtrl {

    @Autowired
    VisitDao visits;

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    String home(HttpServletRequest request) {

        visits.insert(new Date(), request.getHeader(HttpHeaders.USER_AGENT));

        StringWriter buf = new StringWriter();
        PrintWriter out = new PrintWriter(buf);

        out.println(String.format("Got %d visits so far", visits.getCount()));

        out.println("----------");
        out.println("Last 10 visits:");

        for (Visit visit : visits.getLastVisits(10)) {
            out.println(String.format("%tc: %s", visit.getDatetime(), visit.getUseragent()));
        }

        return buf.toString();
    }
}
