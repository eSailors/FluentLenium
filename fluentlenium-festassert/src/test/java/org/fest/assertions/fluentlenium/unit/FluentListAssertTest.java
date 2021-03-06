package org.fest.assertions.fluentlenium.unit;

import org.fest.assertions.fluentlenium.FluentLeniumAssertions;
import org.fest.assertions.fluentlenium.custom.FluentListAssert;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class FluentListAssertTest<E extends FluentWebElement> {

    @Mock
    FluentList<E> fluentList;

    FluentListAssert listAssert;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        listAssert = FluentLeniumAssertions.assertThat(fluentList);
    }

    @Test
    public void testHasText() {
        when(fluentList.getTexts()).thenReturn(Arrays.asList("some text"));
        assertNotNull(listAssert.hasText("some text"));
    }

    @Test
    public void testHasNotText() {
        when(fluentList.getTexts()).thenReturn(Arrays.asList("other text"));
        assertNotNull(listAssert.hasNotText("some text"));
    }

    @Test
    public void testHasSizeOk() {
        when(fluentList.size()).thenReturn(7);
        assertNotNull(listAssert.hasSize(7));
    }

    @Test(expected = AssertionError.class)
    public void testHasSizeKo() {
        when(fluentList.size()).thenReturn(7);
        listAssert.hasSize(5);
    }

    @Test
    public void testHasSizeLessThanOk() {
        when(fluentList.size()).thenReturn(7);
        assertNotNull(listAssert.hasSize().lessThan(9));
    }

    @Test(expected = AssertionError.class)
    public void testHasSizeLessThanKo() {
        when(fluentList.size()).thenReturn(7);
        listAssert.hasSize().lessThan(7);
        listAssert.hasSize().lessThan(6);
    }

    @Test
    public void testHasSizeLessThanOrEqualToOk() {
        when(fluentList.size()).thenReturn(7);
        assertNotNull(listAssert.hasSize().lessThanOrEqualTo(7));
        assertNotNull(listAssert.hasSize().lessThanOrEqualTo(8));
    }

    @Test(expected = AssertionError.class)
    public void testHasSizeLessThanOrEqualToKo() {
        when(fluentList.size()).thenReturn(7);
        listAssert.hasSize().lessThanOrEqualTo(6);
    }

    @Test
    public void testHasSizeGreaterThanOk() {
        when(fluentList.size()).thenReturn(7);
        assertNotNull(listAssert.hasSize().greaterThan(6));
    }

    @Test(expected = AssertionError.class)
    public void testHasSizeGreaterThanKo() {
        when(fluentList.size()).thenReturn(7);
        listAssert.hasSize().greaterThan(7);
        listAssert.hasSize().greaterThan(8);
    }

    @Test
    public void testHasSizeGreaterThanOrEqualToOk() {
        when(fluentList.size()).thenReturn(7);
        assertNotNull(listAssert.hasSize().greaterThanOrEqualTo(7));
        assertNotNull(listAssert.hasSize().greaterThanOrEqualTo(6));
    }

    @Test(expected = AssertionError.class)
    public void testHasSizeGreaterThanOrEqualToKo() {
        when(fluentList.size()).thenReturn(7);
        listAssert.hasSize().greaterThanOrEqualTo(8);
    }

    @Test
    public void testHasIdOk() {
        when(fluentList.getIds()).thenReturn(Arrays.asList("some id"));
        listAssert.hasId("some id");
    }

    @Test(expected = AssertionError.class)
    public void testHasIdKo() throws Exception {
        when(fluentList.getIds()).thenReturn(Arrays.asList("other id"));
        listAssert.hasId("some id");
    }

    @Test(expected = AssertionError.class)
    public void testHasIdEmptyKo() throws Exception {
        when(fluentList.getIds()).thenReturn(Collections.<String>emptyList());
        listAssert.hasId("some id");
    }

    @Test
    public void testHasClassOk() {
        when(fluentList.getAttributes("class")).thenReturn(Arrays.asList("some class"));
        listAssert.hasClass("some class");
    }

    @Test(expected = AssertionError.class)
    public void testHasClassKo() {
        when(fluentList.getAttributes("class")).thenReturn(Arrays.asList("other class"));
        listAssert.hasClass("some class");
    }

    @Test(expected = AssertionError.class)
    public void testHasClassEmptyKo() {
        when(fluentList.getAttributes("class")).thenReturn(Collections.<String>emptyList());
        listAssert.hasClass("some class");
    }

}
