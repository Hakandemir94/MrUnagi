
Cypress.Commands.add('login', (username, password) => {
    cy.get('[data-qa="login-email"]').type(username)
    cy.get('[data-qa="login-password"]').type(password)
    cy.get('[data-qa="login-button"]').click()
})

Cypress.Commands.add('search', (input) => {
    cy.get('input[type="text"][name="search"][id="search_product"]').type(input)
    cy.get('[id="submit_search"]').click()
})