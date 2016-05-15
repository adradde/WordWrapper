package com.epam.lisovyn;

import jdk.nashorn.internal.ir.annotations.Ignore;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static junit.framework.Assert.assertEquals;

/**
 * Created by adrade on 14.05.2016.
 */
public class WordWrapperTest {

	public static final String TEST_STRING = "test string";
	public static final int FOUR_SYMBOLS_LONG = 4;
	public static final String TEST_STRING_WITH_SEPARATOR = "test" + lineSeparator() + "string";
	public static final String ONE_WORD_TEST_STRING = "teststring";
	private WordWrapper ww;

	@Before
	public void shouldReturnWordWrapper() {
		ww = new WordWrapper();
	}

	@Test
	public void shouldReturnStringIfGetNotNull() {
		Assert.assertNotNull(ww.wrap(TEST_STRING, FOUR_SYMBOLS_LONG));
	}

	@Test
	public void shouldBreakLineIfWordIsLonger() {
		assertEquals(TEST_STRING_WITH_SEPARATOR, ww.wrap(ONE_WORD_TEST_STRING, FOUR_SYMBOLS_LONG));
	}

	@Test
	public void shouldReturnStringWithWordOnNewLine() {
		assertEquals(TEST_STRING_WITH_SEPARATOR, ww.wrap(TEST_STRING, TEST_STRING.length() - 2));
	}

	@Ignore
	@Test
	public void shouldThrowIAEIfGetNull() {

	}
}
