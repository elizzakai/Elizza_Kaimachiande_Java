package com.company.chatterbook;

import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.*;

import static java.util.Locale.filter;


@RestController
public class ChatterbookController {
    List<User> userList = new ArrayList<>();

    public ChatterbookController() {
        User luis = new User("Luis");
        User sue = new User("Sue");
        User timothy = new User("Timothy");
        User george = new User("George");
        User arturo = new User("Arturo");
        User mariella = new User("Mariella");
        User paolo = new User("Paolo");
        User tri = new User("Tri");
        User jane = new User("Jane");
        User carol = new User("Carol");
        User carl = new User("Carl");

        luis.setChatterPosts(Arrays.asList(new ChatterPost("Hey! This is my first post!"), new ChatterPost("Anybody want to be friends?")));
        sue.setChatterPosts(Arrays.asList(new ChatterPost("I'm bored"), new ChatterPost("Who wants to hang?")));
        timothy.setChatterPosts(Arrays.asList(new ChatterPost("My life is awesome!"), new ChatterPost("Click here to buy my vegan shakes!")));
        george.setChatterPosts(Arrays.asList(new ChatterPost("I like pigs."), new ChatterPost("I love lamp.")));
        arturo.setChatterPosts(Arrays.asList(new ChatterPost("My cat is so cute"), new ChatterPost("My kitten is purr-fect.")));
        mariella.setChatterPosts(Arrays.asList(new ChatterPost("I'll never post again")));
        paolo.setChatterPosts(Arrays.asList(new ChatterPost("Have you ever heard of the band Nirvana?"), new ChatterPost("Pearl Jam 4 Life")));
        tri.setChatterPosts(Arrays.asList(new ChatterPost("You definitely grew up in the 90s if you get these 10 references."), new ChatterPost("I don't get this generation? Everyone expects a participation trophy.")));
        jane.setChatterPosts(Arrays.asList(new ChatterPost("I just wrecked my dad's car. He's going to kill me!"), new ChatterPost("Grounded.... for 5 months :( ")));
        carol.setChatterPosts(Arrays.asList(new ChatterPost("Does anyone have some imodium?")));
        carl.setChatterPosts(Arrays.asList(new ChatterPost("My roommate is awful!!!!"), new ChatterPost("Anyone know a room for rent in Hyde Park?")));

        userList = Arrays.asList(luis, sue, timothy, george, arturo, mariella, paolo, tri, jane, carol, carl);
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hello() {
        return "hi from spring bot! " + userList.toString();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> list_of_users() {
        if (userList != null) {return userList;}
        return null;
    }

    @RequestMapping(value = "/users/index/{indx}", method = RequestMethod.GET)
    public User getUserByIndx(@PathVariable int indx) {
        return userList.get(indx);
    }

    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET)
    public User getUserByN(@PathVariable String name) {
        for (User us : userList) {
            if (us.getName().equals(name)) {
                return us;
            }
        }
        return null;
    }

    @RequestMapping(value = "/users/posts/{name}", method = RequestMethod.GET)
    public List<ChatterPost> getChatterPostsPerUser(@PathVariable String name) {
        for (User us : userList) {
            if (us.getName().equals(name)) {
                return us.getChatterPosts();
            }
        }
        return null;
    }
;



//    @RequestMapping(value = "/sup", method = RequestMethod.GET)
//    public String li () {
//        setUp();
//        return "hey u there";
//    }


    }
