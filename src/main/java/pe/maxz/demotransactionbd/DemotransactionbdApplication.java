package pe.maxz.demotransactionbd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import pe.maxz.service.SaleService;

@SpringBootApplication
public class DemotransactionbdApplication implements CommandLineRunner{
    //Add Logger
	private static Logger LOG = LoggerFactory.getLogger(DemotransactionbdApplication.class);

    @Autowired
    JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(DemotransactionbdApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		LOG.info("Start..");
		SaleService saleService = new SaleService(jdbcTemplate);
		saleService.save();
		LOG.info("End");
	}
}
