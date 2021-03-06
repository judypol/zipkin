/**
 * Copyright 2015-2017 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package zipkin.storage.elasticsearch.http;

import com.google.auto.value.AutoValue;
import zipkin.internal.Nullable;

@AutoValue
abstract class IndexTemplates {
  static Builder builder() {
    return new AutoValue_IndexTemplates.Builder();
  }

  abstract float version();

  /** null when multi-type indexes are not supported */
  @Nullable abstract String legacy();

  /** null when dots in field names are not supported */
  @Nullable abstract String span();

  /** null when dots in field names are not supported */
  @Nullable abstract String dependency();

  @AutoValue.Builder interface Builder {
    Builder version(float version);

    Builder legacy(@Nullable String legacy);

    Builder span(String span);

    Builder dependency(String dependency);

    IndexTemplates build();
  }
}
