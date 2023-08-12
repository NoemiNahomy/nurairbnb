# Microsevicios!
La siguiente aplicación implementa los siguientes servicios:

## metodo de pago

Micro servicio encargado de gestionar las metodos de pago qué estarán disponibles para las reservas en el en la aplicación. Estos métodos de pago para las transacciones en las reservas.

### Funcionalidades

**Registro de metodo de pago**

Permite el registro de un metodo de pago el cual será gestionado por el micro servicio.

**Listado de metodos de pago**

Permite listar todas los metodos de pago de tipo paypal o tarjeta

**Detalle del metodo de pago**

Permite ver el detalle del metodo de pago

**Registro transaccion**

Permite registrar una transaccion

**Listado de transacciones**

Permite listar los transacciones registradas con los montos

**Detalle de transacciones**

Permite buscar una transacción específica.


## Video
Enlace: 
video [Microservicio](https://drive.google.com/file/d/1YypSKAEk6OrXtfCyt8jMgdv5YMtPBAnh/view),

## Api

 ```
{
  "openapi": "3.0.1",
  "info": {
    "title": "Check in Domain",
    "version": "1.0.0"
  },
  "servers": [
    {
      "url": "http://localhost:8082",
      "description": "Generated server url"
    }
  ],
  "paths": {
    "/transacction/create": {
      "post": {
        "tags": [
          "transacction-controller"
        ],
        "operationId": "createTipo",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/TransactionPagoDto"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/TransactionPagoDto"
                }
              }
            }
          }
        }
      }
    },
    "/metodopago/create": {
      "post": {
        "tags": [
          "metodo-pago-controller"
        ],
        "operationId": "createTipo_1",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/MetodoPagoDto"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/MetodoPagoDto"
                }
              }
            }
          }
        }
      }
    },
    "/transaction/{id}": {
      "get": {
        "tags": [
          "transacction-controller"
        ],
        "operationId": "getMetodoPago",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "string"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/TransactionPagoDto"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/transacction-list": {
      "get": {
        "tags": [
          "transacction-controller"
        ],
        "operationId": "getListAllTipoPropiedades",
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/TransactionPagoDto"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/metodopago/{id}": {
      "get": {
        "tags": [
          "metodo-pago-controller"
        ],
        "operationId": "getMetodoPago_1",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "string"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/MetodoPagoDto"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/metodopago-list": {
      "get": {
        "tags": [
          "metodo-pago-controller"
        ],
        "operationId": "getListAllTipoPropiedades_1",
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/MetodoPagoDto"
                  }
                }
              }
            }
          }
        }
      }
    }
  },
  "components": {
    "schemas": {
      "TransactionPagoDto": {
        "type": "object",
        "properties": {
          "code": {
            "type": "string"
          },
          "descripcion": {
            "type": "string"
          },
          "monto": {
            "type": "number",
            "format": "double"
          }
        }
      },
      "MetodoPagoDto": {
        "type": "object",
        "properties": {
          "id": {
            "type": "string",
            "format": "uuid"
          },
          "detalle": {
            "type": "string"
          },
          "tipo": {
            "type": "string"
          }
        }
      }
    }
  }
}
```

