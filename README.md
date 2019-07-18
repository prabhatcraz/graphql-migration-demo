Using graphql-spqr, we can easily migrate our rest apis to GraphQL.

This gives the possibility to:
1. support Rest Endpoint and GraphQL queries parallely. Thus clients can migrate at their own pace.
2. By pushing all business logic to *Service classes, we make sure to keep our business logic updated, and avoid code duplication.
