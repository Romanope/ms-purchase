# Getting Started

## O que fiz

* Projeto construído baseado no Design do DDD. Sempre que posso, utilizo algumas coisas do Clean Arch, como o Use Case. Acredito que é uma boa alternativa à Service. Como aqui são poucas operações, optei pelas Service, mas em projeto real, avaliaria a possibilidade do Use Case como request handler.
* Contrução de uma API com Spring Boot Web
* Uso do lombok
* Uso do spring openfeign client (Poderíamos usar uma abordagem sem bloqueio com o Spring Web Client, se necessário.)
* Criação de um Exception Handler para centralizar um payload de resposta padrão para os cenário de erros 4xx e 5xx.
* Criação de testes unitário utilizando mockito para exemplificar (Em um cenário real, exercitar todos os cenários).

## O que gostaria de ter feito

* Implementar logs de auditoria utilizando programação orienta à aspecto.
* Utilizar o projeto do Sprint Sleuth para geração de ids transacionais. (TraceId, ParentId, SpanId).
* Criar uma camada para envio de métrica da aplicação de forma abstrata utilizando uma das implementaçõs do OTEL.
* Poderia melhorar a performance das operações que utilizam mais de uma chamada de API para processar a solicitação, introduzindo uma abordagem async com CompletableFeature. Iniciaria todas as requisições e aguardaria o resultado.  
* 


