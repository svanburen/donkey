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

package com.appsflyer.donkey.server.handler;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

/**
 * Handler that adds a {@code Server} header to the response
 */
public final class ServerHeaderHandler implements Handler<RoutingContext> {
  
  private static final String SERVER_PROP = "Server";
  static final String SERVER_NAME = "Donkey";
  
  public static ServerHeaderHandler create() {
    return new ServerHeaderHandler();
  }
  
  private ServerHeaderHandler() {}
  
  @Override
  public void handle(RoutingContext ctx) {
    ctx.addHeadersEndHandler(v -> ctx.response().putHeader(SERVER_PROP, SERVER_NAME));
    ctx.next();
  }
  
}
