package io.icarus7.mazin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class Logic {

    @Test
    public void all(){
        Flux<String> newEngland = Flux.just("Massachusetts", "Connecticut", "Vermont", "New Hampshire", "Maine", "Rhode Island");

        Mono<Boolean> doAllStatesHaveLetterE = newEngland.all(state -> state.contains("e"));

        StepVerifier.create(doAllStatesHaveLetterE)
                .expectNext(true)
                .expectComplete()
                .verify();

        Mono<Boolean> doAllStatesHaveLetterZ = newEngland.all(state -> state.contains("z"));

        StepVerifier.create(doAllStatesHaveLetterZ)
                .expectNext(false)
                .expectComplete()
                .verify();
    }




    @Test
    public void any(){
        Flux<String> newEngland = Flux.just("Massachusetts", "Connecticut", "Vermont", "New Hampshire", "Maine", "Rhode Island");

        Mono<Boolean> statesWithLetterM = newEngland.any(state -> state.contains("m"));

        StepVerifier.create(statesWithLetterM)
                .expectNext(true)
                .expectComplete()
                .verify();

        Mono<Boolean> statesWithLetterZ = newEngland.any(state -> state.contains("z"));

        StepVerifier.create(statesWithLetterZ)
                .expectNext(false)
                .expectComplete()
                .verify();
    }
}
