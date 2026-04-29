# 🎪 FestPay API

Sistema backend para gerenciamento de vendas em eventos (festas, feiras, shows, etc), com foco em **redução de filas**, **organização de pedidos** e **experiência digital para o cliente**.

---

## 🧠 Sobre o Projeto

O **FestPay** é uma API REST que permite que organizadores de eventos criem um ambiente digital onde barraquinhas podem cadastrar produtos e clientes podem realizar pedidos diretamente pelo celular.

📱 O cliente faz o pedido → recebe um **QR Code** → apresenta na retirada
🍔 A barraquinha gerencia os pedidos em tempo real

---

## 🎯 Problema que resolve

Em eventos tradicionais:

* ❌ Filas longas para compra
* ❌ Falta de organização nos pedidos
* ❌ Controle manual de vendas

O sistema resolve isso com:

* ✅ Pedidos digitais
* ✅ Fluxo organizado por status
* ✅ Retirada via QR Code
* ✅ Centralização de vendas

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura **modular (DDD-lite)**, organizada por domínios:

```
modules/
 ├── event/
 ├── vendor/
 ├── product/
 ├── order/
 └── user/

shared/
 ├── auth/
 ├── infra/
 └── utils/
```

---

## 🧩 Principais Entidades

* **User** → usuários do sistema (admin, vendor, cliente)
* **Event** → eventos criados pelos organizadores
* **Vendor** → barraquinhas dentro de um evento
* **Product** → produtos vendidos pelas barraquinhas
* **Order** → pedidos realizados pelos clientes
* **OrderItem** → itens do pedido

---

## 🔐 Autenticação

* JWT (JSON Web Token)
* Controle por roles:

```
EVENT_OWNER
VENDOR
CUSTOMER
```

---

## 🔄 Fluxo do Pedido

1. Cliente acessa evento
2. Escolhe uma barraquinha
3. Seleciona produtos
4. Cria pedido
5. Sistema:

    * valida estoque
    * calcula total
    * gera QR Code
6. Barraquinha recebe pedido
7. Atualiza status:

```
CREATED → PREPARING → READY → DELIVERED
```

---

## 📦 Regras importantes

* Cada pedido pertence a **uma única barraquinha**
* O preço do produto é salvo no momento da compra (`price_at_time`)
* O estoque é decrementado na criação do pedido
* O QR Code identifica o pedido de forma única

---

## 📡 Endpoints principais

### 🔐 Auth

```
POST /auth/login
POST /users
```

### 🎉 Events

```
POST /events
GET  /events
GET  /events/{id}
```

### 🏪 Vendors

```
POST /events/{id}/vendors
GET  /events/{id}/vendors
```

### 🍔 Products

```
POST /vendors/{id}/products
GET  /vendors/{id}/products
PATCH /products/{id}
```

### 🧾 Orders

```
POST /orders
GET  /orders/{id}
PATCH /orders/{id}/status
```

### 💳 Payment (simulado)

```
POST /orders/{id}/pay
```

---

## ⚙️ Tecnologias

* Java + Spring Boot *(ou Node.js / NestJS)*
* PostgreSQL
* Docker
* JWT Authentication

---

## 🐳 Como rodar o projeto

### Pré-requisitos

* Docker
* Docker Compose

### Subir ambiente

```
docker-compose up --build
```

A API estará disponível em:

```
http://localhost:8080
```

---

## 📄 Documentação da API

Swagger disponível em:

```
/swagger
```

---

## 🧪 Testes

*(opcional – implementar)*

* Testes de serviço
* Testes de criação de pedidos

---

## 🚀 Diferenciais do Projeto

* ✅ Controle de pedidos em tempo real (preparado para WebSocket)
* ✅ Sistema baseado em eventos (multi-tenant)
* ✅ QR Code para retirada
* ✅ Arquitetura modular
* ✅ Pronto para escalar

---

## 📌 Roadmap (melhorias futuras)

* WebSocket para atualização em tempo real
* Integração com pagamento real
* Dashboard analítico
* Sistema de notificações
* Multi-eventos simultâneos

---
