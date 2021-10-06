// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  UserUrl: "http://hackathon-demo-hackathon-demo.chennaidevops49.conygre.com/api/trading/User",
  OrderUrl: "http://hackathon-demo-hackathon-demo.chennaidevops49.conygre.com/api/trading/Order",
  AvailUrl: "http://hackathon-demo-hackathon-demo.chennaidevops49.conygre.com/api/trading/Available",
  HistoryUrl: "http://hackathon-demo-hackathon-demo.chennaidevops49.conygre.com/api/trading/History",
  newsUrl: "https://newsapi.org/v2/everything?q=fintech&from=2021-08-31&sortBy=popularity&apiKey=a330d99ab13b4562805323794b874dca"

};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
