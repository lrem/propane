/**
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2016 moo.io , Erhan Bagdemir
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package io.moo.propane.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bagdemir
 * @version 1.0
 * @since 1.0
 */
public interface Context {

  /**
   * Tie breaker, if two context info stays in conflict during election.
   *
   * @return Priority of the context. Lower the priority, better while electing the context infos.
   */
  int getPriority();

  /**
   * Unique context identifier, that used in context id to context instance or
   * vice versa
   * (de)serialization.
   *
   * @return
   */
  String getContextId();
}
