/*
 * Copyright 2020 AppsFlyer
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.appsflyer.donkey.server.route;

import com.appsflyer.donkey.TestUtil;
import com.appsflyer.donkey.server.ServerConfig;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.junit5.VertxExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.appsflyer.donkey.TestUtil.DEFAULT_PORT;

@Tag("integration")
@ExtendWith(VertxExtension.class)
public class RoutingTest extends AbstractRoutingTest {
  
  private static final RouteSupplier routeSupplier = new RouteSupplierImpl();
  
  @Override
  protected ServerConfig newServerConfig(Vertx vertx, RouteList routeList) {
    return ServerConfig
        .builder()
        .vertx(vertx)
        .instances(4)
        .serverOptions(new HttpServerOptions().setPort(DEFAULT_PORT))
        .routeList(routeList)
        .routeCreatorFactory(TestUtil::newRouteCreator)
        .build();
  }
  
  @Override
  protected RouteSupplier routeSupplier() {
    return routeSupplier;
  }
}
