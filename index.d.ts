declare module 'zendesk-sdk-react-native' {
  // normal init function when you want to use all of the sdks
  export function init(initializationOptins: InitOptions, callback: CallbackFunction): void;

  // function to show the conversation screen.
  export function showMessaging(): void;

  export interface InitOptions {
    // chat key of zendesk account to init chat
    key: string,
  }

  export type CallbackFunction = (error: string | null) => void;
}