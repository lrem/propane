/**
 *
 *   The MIT License (MIT)
 *
 *   Copyright (c) 2015 moo.io , Erhan Bagdemir
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 *
 */
package io.moo.propane.extractors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import io.moo.propane.extractors.DefaultContextExtractor;
import org.junit.Test;

import io.moo.propane.exception.InvalidPropertyNameException;
import io.moo.propane.extractors.DefaultContextExtractor;

/**
 * @author bagdemir
 * @version 1.0
 * @since 1.0
 */
public class DefaultContextExtractorTest {

  @Test
  public void testExtractContext() {
    final DefaultContextExtractor extractor = new DefaultContextExtractor();
    final String extract = extractor.extract("us.dev.a/io.moo/propName");
    assertThat(extract, notNullValue());
    assertThat(extract, equalTo("us.dev.a"));

  }

  @Test(expected = InvalidPropertyNameException.class)
  public void testExtractWithBlankPropertyName() {
    new DefaultContextExtractor().extract("");
  }

  @Test(expected = InvalidPropertyNameException.class)
  public void testExtractWithNullPropertyName() {
    new DefaultContextExtractor().extract(null);
  }

  @Test
  public void testExtractMultiSegmentPropertyNameWithoutContext() {
    final DefaultContextExtractor extractor = new DefaultContextExtractor();
    assertThat(extractor.extract("b/propName"), equalTo(null));
  }
}