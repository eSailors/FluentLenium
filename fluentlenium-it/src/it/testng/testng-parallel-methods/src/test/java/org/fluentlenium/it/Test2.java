package org.fluentlenium.it;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test2 extends FluentIntegTestNg {
    @Test
    public void test5() {
        goTo(UrlUtil.getAbsoluteUrlFromFile("inputs.html"));
        findFirst("input").fill().with("5");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
        }

        assertThat(findFirst("input").getValue()).isEqualTo("5");
    }

    @Test
    public void test6() {
        goTo(UrlUtil.getAbsoluteUrlFromFile("inputs.html"));
        findFirst("input").fill().with("6");

        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
        }

        assertThat(findFirst("input").getValue()).isEqualTo("6");
    }

    @Test
    public void test7() {
        goTo(UrlUtil.getAbsoluteUrlFromFile("inputs.html"));
        findFirst("input").fill().with("7");

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
        }

        assertThat(findFirst("input").getValue()).isEqualTo("7");
    }

    @Test
    public void test8() {
        goTo(UrlUtil.getAbsoluteUrlFromFile("inputs.html"));
        findFirst("input").fill().with("8");

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
        }

        assertThat(findFirst("input").getValue()).isEqualTo("8");
    }
}
