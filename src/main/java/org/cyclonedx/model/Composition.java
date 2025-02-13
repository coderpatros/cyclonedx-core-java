/*
 * This file is part of CycloneDX Core (Java).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) OWASP Foundation. All Rights Reserved.
 */
package org.cyclonedx.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"aggregate", "assemblies", "dependencies"})
public class Composition {

    public enum Aggregate {
        @JsonProperty("complete")
        COMPLETE("complete"),
        @JsonProperty("incomplete")
        INCOMPLETE("incomplete"),
        @JsonProperty("incomplete_first_party_only")
        INCOMPLETE_FIRST_PARTY_ONLY("incomplete_first_party_only"),
        @JsonProperty("incomplete_third_party_only")
        INCOMPLETE_THIRD_PARTY_ONLY("incomplete_third_party_only"),
        @JsonProperty("unknown")
        UNKNOWN("unknown"),
        @JsonProperty("not_specified")
        NOT_SPECIFIED("not_specified");

        private final String name;

        public String getAggregateName() {
            return this.name;
        }

        Aggregate(String name) {
            this.name = name;
        }
    }

    private Aggregate aggregate;
    private List<BomReference> assemblies;
    private List<BomReference> dependencies;

    public Aggregate getAggregate() {
        return aggregate;
    }

    public void setAggregate(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    public List<BomReference> getAssemblies() {
        return assemblies;
    }

    public void setAssemblies(List<BomReference> assemblies) {
        this.assemblies = assemblies;
    }

    public void addAssembly(BomReference assembly) {
        if (assemblies == null) {
            assemblies = new ArrayList<>();
        }
        assemblies.add(assembly);
    }

    public List<BomReference> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<BomReference> dependencies) {
        this.dependencies = dependencies;
    }

    public void addDependency(BomReference dependency) {
        if (dependencies == null) {
            dependencies = new ArrayList<>();
        }
        dependencies.add(dependency);
    }
}
