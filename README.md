# Getting Started

## O que fiz

* Java 17
* Projeto construído baseado no Design do DDD. Sempre que posso, utilizo algumas coisas do Clean Arch, como o Use Case. Acredito que é uma boa alternativa à Service. Como aqui são poucas operações, optei pelas Service, mas em projeto real, avaliaria a possibilidade do Use Case como request handler.
* Contrução de uma API com Spring Boot Web
* Uso do lombok
* Uso do spring openfeign client (Poderíamos usar uma abordagem sem bloqueio com o Spring Web Client, se necessário.)
* Criação de um Exception Handler para centralizar um payload de resposta padrão para os cenário de erros 4xx e 5xx.
* [Criação de testes unitário utilizando mockito para exemplificar (Em um cenário real, exercitar todos os cenários)](https://github.com/Romanope/purchase-reporter/blob/d1cf4e2ad44d088d05249329af7540f1dab84fb3/src/test/java/com/magazine/domain/purchase/PurchaseServiceTest.java#L34)

## O que gostaria de/poderia ter feito

* Implementar logs de auditoria utilizando programação orienta à aspecto.
* Utilizar o projeto do Sprint Sleuth para geração de ids transacionais. (TraceId, ParentId, SpanId).
* Criar uma camada para envio de métricas (Para uma ferramenta de monitoramento que dê suporte à APM) da aplicação de forma abstrata utilizando uma das implementaçõs do OTEL.
* Poderia melhorar a performance das operações que utilizam mais de uma chamada de API para processar a solicitação, introduzindo uma abordagem async com CompletableFeature. Iniciaria todas as requisições e aguardaria o resultado.
* Analisar possibilidade de uso cache distribuído, com TTL curto. Penso que até um cache em memória local poderia ajudar aqui, mas necessário avaliar.
* Normalmente não utilizo camada de segurança na aplicação, mas sim em Gateway que consome de um Keycloak (ou outra ferramenta de gestão de acessos). Mas se for o caso, poderia pensar em usar spring security com oauth2 ou OIDC.
* Implementação de teste de integração com rest assured e mock server ou outros frameworkk similares (realmente não tive tempo.)
* Exemplo de implementação de test de contratos.
* Poderia implementar TestContainer, é uma boa alternativa para simplificar especialmente os dados mockados.
* Uso de variáveis de ambiente.
* Integrar com um gerenciados de Feature Flags para ralizar rollouts seguros de novas features ou mudanças.
* Poderia integrar o repositório com uma esteira de deploy, Jenkings, Spinnaker, Github ACtions etc.
* Poderia ter criado algumas actions no repositório para fazer build e execução dos testes ao abrir PRs.
