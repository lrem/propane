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
package io.moo.propane;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import io.moo.propane.exception.InvalidPropertyNameException;
import io.moo.propane.extractors.DefaultPropertyNameExtractor;

/**
 * @author bagdemir
 * @version 1.0
 * @since 1.0
 */
public class DefaultPropertyNameExtractorTest {

  @Test
  public void testExtractSingleSegmentPropertyName() {
    final DefaultPropertyNameExtractor extractor = new DefaultPropertyNameExtractor();
    assertThat(extractor.extract("propName"), equalTo("propName"));
  }

  @Test(expected = InvalidPropertyNameException.class)
  public void testExtractWithBlankPropertyName() {
    new DefaultPropertyNameExtractor().extract("");
  }

  @Test(expected = InvalidPropertyNameException.class)
  public void testExtractWithNullPropertyName() {
    new DefaultPropertyNameExtractor().extract(null);
  }

  @Test
  public void testExtractMultiSegmentPropertyName() {
    final DefaultPropertyNameExtractor extractor = new DefaultPropertyNameExtractor();
    assertThat(extractor.extract("a/b/propName"), equalTo("propName"));
  }
}
