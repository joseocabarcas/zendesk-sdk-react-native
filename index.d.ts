declare module 'zendesk-sdk-react-native' {
  // normal init function when you want to use all of the sdks
  export function init(initializationOptins: InitOptions): void;

  export interface InitOptions {
    // chat key of zendesk account to init chat
    key: string,
    // appId of your zendesk account
    appId: string,
    // clientId of your zendesk account
    clientId: string,
    // support url of zendesk account
    url: string,
  }
}