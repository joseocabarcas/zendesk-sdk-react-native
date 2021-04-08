declare module '@joseocabarcas/zendesk-sdk-react-native' {
  // normal init function when you want to use all of the sdks
  export function init(initializationOptins: InitOptions): Promise<string | null>;

  // function to show the conversation screen.
  export function showMessaging(): void;

  export interface InitOptions {
    // chat key of zendesk account to init chat
    key: string,
  }
}