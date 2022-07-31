
export interface response {
  meta: {
    copyright : string
    authors: string
    status: boolean
  }
  data: {
    alias: string
    cbu: string
    cta_$: number
    cta_u$$: number
    email: string
    firstname: string
    id: number
    lastname: string
    password: string
  }
  error: {
    err_number: number
    message: string
  }
}



// interface response2 {
//   "data": {
//     "id": 1,
//     "firstname": "Federico",
//     "lastname": "Wagner",
//     "email": "fedeWag@gmail.com",
//     "password": "123456",
//     "alias": "fede.mara.perro",
//     "cbu": "123456789",
//     "cta_$": 11532.48,
//     "cta_u$$": 525.46,
//     "transactions_sent": [
//       {
//         "type": {
//           "currency": "Pesos"
//         },
//         "receptor": {
//           "firstname": "Natalia",
//           "lastname": "Garcia"
//         },
//         "amount": 500.0,
//         "date": "2022-07-14 11:19:37"
//       },
//       {
//         "type": {
//           "currency": "Pesos"
//         },
//         "receptor": {
//           "firstname": "Agustin",
//           "lastname": "Martinez"
//         },
//         "amount": 300.0,
//         "date": "2022-07-12 11:19:37"
//       }
//     ],
//     "transactions_received": [
//       {
//         "type": {
//           "currency": "Pesos"
//         },
//         "giver": {
//           "firstname": "Natalia",
//           "lastname": "Garcia"
//         },
//         "amount": 250.0,
//         "date": "2022-07-13 11:22:01"
//       }
//     ]
//   },
//   "meta": {
//     "copyright": "Copyright 2015 Example Corp.",
//     "authors": "[Federico Wagner]",
//     "status": true
//   }
// }
