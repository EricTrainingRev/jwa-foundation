package com.example.demo;

import com.example.demo.utility.JavalinSetup;

import io.javalin.Javalin;

public class Main {

	public static void main(String[] args) {
		Javalin app = Javalin.create(config ->{
			config.bundledPlugins.enableCors(cors -> {
				cors.addRule(it -> {
					it.anyHost();
				});
			});
			config.bundledPlugins.enableDevLogging();
			config.staticFiles.add("/pages");
		});

		JavalinSetup.mapRoutes(app);

		app.start(8080);
	}

}
