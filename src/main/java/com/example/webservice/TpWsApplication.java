package com.example.webservice;

import com.example.webservice.connection.ConnectDB;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.Connection;
import java.sql.SQLException;


public class TpWsApplication{
	/*private static ConnectDB PostgreSQL;
//	private static ConnectDB SQLServer;

	public static ConnectDB getPostgreSQL() {
		return PostgreSQL;
	}

	public void setPostgreSQL(ConnectDB postgreSQL) {
		PostgreSQL = postgreSQL;
	}

	public static void main(String[] args) {
		SpringApplication.run(TpWsApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "PUT", "POST", "DELETE").allowedOrigins("*");
			}
		};
	}

	@Override
	public void run(String... args) throws Exception {
		try
		{
			PostgreSQL=new ConnectDB("jdbc:postgresql://floppy.db.elephantsql.com/wvsusyqf","wvsusyqf","LzM44nfas4Vrl6XZTVK1s1eMXeXrej7I");
			if(PostgreSQL!=null) System.out.println("Connected to PostgreSQL - Enchere");
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			System.out.println("Exception_"+sqle.getMessage());
		}
		Connection connection = PostgreSQL.getConnection();
//		Connection connectionSqlServer = SQLServer.getConnection();
		System.out.println("Web Services is ready ...");
	}*/
}
