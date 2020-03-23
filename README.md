# Vault Secrets in the Codefresh Pipeline

![Vault plus Codefresh](cf-plus-vault.png)

This is a sample application that uses the Codefresh Vault plugin to use secrets within the pipeline.

Note that if you install this locally (`mvn clean install`) the build will fail, as the tests will not have access to the proper enviornment variable that was exported to the pipeline via the plugin.

## Prerequisites

- A [free Codefresh account](https://codefresh.io/docs/docs/getting-started/create-a-codefresh-account/)
- An existing Vault server [already setup](https://learn.hashicorp.com/vault/getting-started/install)
- A secret stored in said Vault server with a key of "password"
- A Vault [authorization token](https://learn.hashicorp.com/vault/getting-started/authentication#tokens)

## Example Usage

Refer to the `codefresh.yml` file and modify the arguments for `VAULT_ADDR`, `VAULT_PATH`, and `VAULT_AUTH_TOKEN`:

```yaml
  vault:
    title: Importing vault values...
    stage: "vault"
    type: vault
    arguments:
      VAULT_ADDR: 'http://<YOUR_VAULT_SERVER_IP>:<PORT>'
      VAULT_PATH: 'path/to/secret'
      VAULT_AUTH_TOKEN: '<YOUR_VAULT_AUTH_TOKEN>'
```
