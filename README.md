j'ai essaye de faire la documentation apres l'integration de spring security (sans gestion des roles) voila la resultat de test de POST utilisateur avec swagger:


Request URL
http://localhost:8080/api/utilisateurs/utilisateurs
Server response
Code	Details

500
Undocumented
Error: response status is 500

Response body
Download
{
  "timestamp": "2025-07-13T22:05:12.535+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/api/utilisateurs/utilisateurs"
}
Response headers
 cache-control: no-cache,no-store,max-age=0,must-revalidate 
 connection: close 
 content-type: application/json 
 date: Sun,13 Jul 2025 22:05:12 GMT 
 expires: 0 
 pragma: no-cache 
 transfer-encoding: chunked 
 x-content-type-options: nosniff 
 x-frame-options: DENY 
 x-xss-protection: 0 
Responses
Code	Description	Links
200	
OK
