describe('Login, Product Search, and Cart Tests', () => {
    beforeEach(() => {
      cy.visit('https://automationexercise.com')
    })
  
    // Login Test
    it('should log in with valid credentials', () => {
      cy.contains('Signup / Login').click()
      cy.login('newuser@user.com', 'a')
      cy.contains('Features Items').should('be.visible')
    })
  
    // Product Search Test
    it('should search for a product', () => {
      cy.get('a[href="/products"]').contains('Products').click()
      cy.search('Blue Top')
      cy.url().should('include', 'products?search=Blue%20Top')
      cy.get('.productinfo p').should('contain', 'Blue Top')
    })
  })
  