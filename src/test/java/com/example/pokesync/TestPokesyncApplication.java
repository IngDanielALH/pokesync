package com.example.pokesync;

import org.springframework.boot.SpringApplication;

public class TestPokesyncApplication {

	public static void main(String[] args) {
		SpringApplication.from(PokesyncApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
