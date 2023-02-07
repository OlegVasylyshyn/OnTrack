// 5. How would you design a REST API

// In REST we as usually use power of methods in HTTP ref: https://www.w3schools.com/tags/ref_httpmethods.asp
// And important to know that PUT is idempotent!
// It means that no matter how many times we hit PUT endpoint with the same parameters - result will be always the same and no side effects for next calls.
// How do you use idempotent theory is deal.
// For example updating entity could be done using PUT.
// If we change one property of an entity after first request - next the same request won't change anything.
// So that PUT will be idempotent.

// Here is my endpoints:

// To Create
// POST method - not idempotent - means the same request will create duplicate addresses, but with different ids (see response).
// URL: hostname/v1/address
// BODY: some json
// RESPONSES:
// OK: 200 {id : "UUID"} // id of entity
// ERRORS RELATED TO FE ISSUES: 4-- {reason:"some reason"}
// SERVER ERRORS: 5-- {reason:"some reason"}

// To Update
// PUT method - idempotent
// URL: hostname/v1/address
// BODY: some json
// RESPONSES:
// OK: 200 {id : "UUID"} // id of entity or event id for event sourcing
// ERRORS RELATED TO FE ISSUES: 4-- {reason:"some reason"}
// SERVER ERRORS: 5-- {reason:"some reason"}

// To READ
// GET method
// URL: hostname/v1/address/{id} // id of entity
// RESPONSES:
// OK: 200 {id : "UUID"}
// ERRORS RELATED TO FE ISSUES: 4-- {reason:"some reason"}
// SERVER ERRORS: 5-- {reason:"some reason"}

// To READ ALL
// GET method
// URL: hostname/v1/address/
// RESPONSES:
// OK: 200 {data : [{}, {}]} // data is array of address entities
// ERRORS RELATED TO FE ISSUES: 4-- {reason:"some reason"}
// SERVER ERRORS: 5-- {reason:"some reason"}

// To REMOVE
// DELETE method
// URL: hostname/v1/address/{id} // id of entity
// RESPONSES:
// OK: 200 {id : "UUID"} // id of deleted object..
// ERRORS RELATED TO FE ISSUES: 4-- {reason:"some reason"}
// SERVER ERRORS: 5-- {reason:"some reason"}
