
Cypress.Commands.add('login', (username, password) => {
    cy.get('[data-qa="login-email"]').type('username')
    cy.get('[data-qa="login-password"]').type('password')
    cy.get('[data-qa="login-button"]').click()
})
Cypress.Commands.add('search', (input) => {
    cy.get('input[type="text"][name="search"][id="search_product"]').type('input')
    cy.get('[id="submit_search"]').click()
})
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })