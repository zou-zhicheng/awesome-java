package tacocloud.controller;

/**
 * HomePageController
 * Catch the request for http get "/"
 *
 * @author insight
 * @since 2021/4/28
 */
// @Controller
public class HomeController {
    // @GetMapping("/")
    public String home() { return "home"; }
}