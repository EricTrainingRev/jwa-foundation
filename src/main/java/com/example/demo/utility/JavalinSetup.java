package com.example.demo.utility;

import org.eclipse.jetty.server.Authentication;

import com.example.demo.controller.MoonController;
import com.example.demo.controller.PlanetController;
import com.example.demo.controller.UserController;
import com.example.demo.controller.ViewController;
import com.example.demo.exceptions.AuthenticationFailed;
import com.example.demo.repository.moon.MoonDao;
import com.example.demo.repository.moon.MoonDaoImp;
import com.example.demo.repository.planet.PlanetDao;
import com.example.demo.repository.planet.PlanetDaoImp;
import com.example.demo.repository.user.UserDao;
import com.example.demo.repository.user.UserDaoImp;
import com.example.demo.service.moon.MoonService;
import com.example.demo.service.moon.MoonServiceImp;
import com.example.demo.service.planet.PlanetService;
import com.example.demo.service.planet.PlanetServiceImp;
import com.example.demo.service.user.UserService;
import com.example.demo.service.user.UserServiceImp;

import io.javalin.Javalin;

public class JavalinSetup {

    final public static UserDao userDao = new UserDaoImp();
    final public static UserService userService = new UserServiceImp(userDao);
    final public static UserController userController = new UserController(userService);

    final public static PlanetDao planetDao = new PlanetDaoImp();
    final public static PlanetService planetService = new PlanetServiceImp(planetDao);
    final public static PlanetController planetController = new PlanetController(planetService);

    final public static MoonDao moonDao = new MoonDaoImp();
    final public static MoonService moonService = new MoonServiceImp(moonDao);
    final public static MoonController moonController = new MoonController(moonService);

    final public static ViewController viewController = new ViewController();

    public static void mapRoutes(Javalin app){

        /*
         * Mapping Authentication and exception handling
         */

        app.before("/planetarium/*", ctx -> userController.authenticateUser(ctx));
        app.exception(AuthenticationFailed.class, (e, ctx) -> {
            ctx.status(401);
            ctx.result(e.getMessage());
        });
        
        /*
         * Mapping Pages to Javalin app
         */

        app.get("/", ctx -> viewController.login(ctx));
        app.get("/register", ctx -> viewController.register(ctx));
        app.get("/planetarium/home", ctx -> viewController.home(ctx));

        /*
         * Mapping User Routes
         */

        app.post("/login", ctx -> userController.login(ctx));
        app.post("/register", ctx -> userController.createUser(ctx));
        app.post("/logout", ctx -> userController.logout(ctx));

        /*
         * Mapping Planet Routes
         */

        app.get("/planetarium/planet", ctx -> planetController.findAll(ctx));
        app.get("/planetarium/planet/owner/{ownerId}", ctx -> planetController.findAllByOwner(ctx));
        app.get("/planetarium/planet/{identifier}", ctx -> planetController.findByIdentifier(ctx));
        app.post("/planetarium/planet", ctx -> planetController.createPlanet(ctx));
        app.patch("/planetarium/planet", ctx -> planetController.updatePlanet(ctx));
        app.delete("/planetarium/planet/{identifier}", ctx -> planetController.deletePlanet(ctx));

        /*
         * Mapping Moon Routes
         */

        app.get("/planetarium/moon", ctx -> moonController.findAll(ctx));
        app.get("/planetarium/moon/owner/{planetId}", ctx -> moonController.findAllByPlanet(ctx));
        app.get("/planetarium/moon/{identifier}", ctx -> moonController.findByIdentifier(ctx));
        app.post("/planetarium/moon", ctx -> moonController.createMoon(ctx));
        app.delete("/planetarium/moon/{identifier}", ctx -> moonController.deleteMoon(ctx));
    }
    
}
