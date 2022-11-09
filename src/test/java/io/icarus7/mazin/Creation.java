package io.icarus7.mazin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class Creation {
    @Test
    public void createAFluxWithJust(){
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Pomegranate", "Strawberry");
        fruitFlux.subscribe(f -> System.out.println("Here's some fruit " + f));

        StepVerifier.create(fruitFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Pomegranate")
                .expectNext("Strawberry")
                .expectComplete()
                .verify();
    }

    @Test
    public void createFluxFromArray(){
        String[] fruits = new String[] {"Apple", "Orange", "Grape", "Pomegranate", "Strawberry"};
        Flux<String> fruitFlux = Flux.fromArray(fruits);
        StepVerifier.create(fruitFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Pomegranate")
                .expectNext("Strawberry")
                .expectComplete()
                .verify();
    }

    @Test
    public void createFluxFromIterable(){
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Grape");
        fruits.add("Pomegranate");
        fruits.add("Strawberry");
        Flux<String> fruitFlux = Flux.fromIterable(fruits);
        StepVerifier.create(fruitFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Pomegranate")
                .expectNext("Strawberry")
                .expectComplete()
                .verify();
    }

    @Test
    public void createFluxFromStream(){
        Stream<String> fruitStream = Stream.of("Apple", "Orange", "Grape", "Pomegranate", "Strawberry");

        Flux<String> fruitFlux = Flux.fromStream(fruitStream);
        StepVerifier.create(fruitFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Pomegranate")
                .expectNext("Strawberry")
                .expectComplete()
                .verify();
    }

    @Test
    public void createFluxFromRange(){
        Flux<Integer> rangeFlux = Flux.range(1,10);

        StepVerifier.create(rangeFlux)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectNext(5)
                .expectNext(6)
                .expectNext(7)
                .expectNext(8)
                .expectNext(9)
                .expectNext(10)
                .expectComplete()
                .verify();
    }


    @Test
    public void createFluxFromInterval(){
        Flux<Long> rangeFlux = Flux.interval(Duration.ofSeconds(1)).take(20);

        StepVerifier.create(rangeFlux)
                .expectNext(0L)
                .expectNext(1L)
                .expectNext(2L)
                .expectNext(3L)
                .expectNext(4L)
                .expectNext(5L)
                .expectNext(6L)
                .expectNext(7L)
                .expectNext(8L)
                .expectNext(9L)
                .expectNext(10L)
                .expectNext(11L)
                .expectNext(12L)
                .expectNext(13L)
                .expectNext(14L)
                .expectNext(15L)
                .expectNext(16L)
                .expectNext(17L)
                .expectNext(18L)
                .expectNext(19L)
                .expectComplete()
                .verify();
    }

}
