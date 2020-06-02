package kr.co.fastcampus.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTests {
    @Test
    public void creation(){
        Restaurant restaurant = new Restaurant("Bob zip","Seoul");
        assertThat(restaurant.getName(), is("Bob zip")); //RED -> GREEN -> Refactoring
        assertThat(restaurant.getAddress(), is("Seoul"));

    }

    @Test
    public void information(){
        Restaurant restaurant = new Restaurant("Bob zip", "Seoul");

        assertThat(restaurant.getInformaiton(),is( "Bob zip in Seoul"));
    }
}