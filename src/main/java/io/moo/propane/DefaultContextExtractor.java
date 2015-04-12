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

import io.moo.propane.exception.InvalidPropertyNameException;

/**
 * @author bagdemir
 * @version 1.0
 * @since 1.0
 */
public class DefaultContextExtractor implements TokenExtractor {
  @Override
  public String extract(final String propertyName) {
    assertPropertyNameIsValid(propertyName);
    if (propertyName.contains("/")) {
      String[] split = propertyName.split("/");
      if (split.length > 2) {
        return split[split.length - 3];
      }
    }
    return null;
  }

  private void assertPropertyNameIsValid(final String propertyName) {
    if (propertyName == null || "".equals(propertyName)) {
      throw new InvalidPropertyNameException();
    }
  }
}
