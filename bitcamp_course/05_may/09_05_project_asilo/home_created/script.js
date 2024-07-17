

// alert pop-up accedi - registrati

function accedi() {
    var html = `
    <div class="card-body accedi">
    <form>

      <div class="form-floating mb-3">
        <input type="text" class="form-control" id="floatingInputUsername" placeholder="myusername" required autofocus>
        <label for="floatingInputUsername">Username</label>
      </div>

      <div class="form-floating mb-3">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Password</label>
      </div>

      <div class="d-grid mb-2">
        <button class="btn btn-lg btn-login fw-bold text-uppercase main-button" type="submit">Accedi</button>
      </div>

      <a class="d-block text-center mt-2 small color" onclick="registrati()" href="#" onClick>Non hai un account? Registrati</a>

      <hr class="my-4">

      <div class="d-grid mb-2">
        <button class="btn btn-lg btn-google btn-login fw-bold text-uppercase" type="submit">
          <i class="fab fa-google me-2"></i> Accedi con Google
        </button>
      </div>

      <div class="d-grid">
        <button class="btn btn-lg btn-facebook btn-login fw-bold text-uppercase" type="submit">
          <i class="fab fa-facebook-f me-2"></i> Accedi con Facebook
        </button>
      </div>

    </form>
    </div>`;

    Swal.fire({
        title: 'Accedi',
        html: html,
        showCloseButton: true,
        showCancelButton: false,
        showConfirmButton: false,
    });
}

function registrati(){
    var html = `
    <div class="card-body registrati">
                    <form>
        
                      <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="floatingInputUsername" placeholder="myusername" required autofocus>
                        <label for="floatingInputUsername">Username</label>
                      </div>
        
                      <div class="form-floating mb-3">
                        <input type="email" class="form-control" id="floatingInputEmail" placeholder="name@example.com">
                        <label for="floatingInputEmail">Email</label>
                      </div>
        
                      <hr>
        
                      <div class="form-floating mb-3">
                        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                        <label for="floatingPassword">Password</label>
                      </div>
        
                      <div class="d-grid mb-2">
                        <button class="btn btn-lg btn-login fw-bold text-uppercase main-button" type="submit">Registrati</button>
                      </div>
        
                      <a class="d-block text-center mt-2 small color" href="#" onclick="accedi()">Hai un account? Accedi</a>
        
                      <hr class="my-4">
        
                      <div class="d-grid mb-2">
                        <button class="btn btn-lg btn-google btn-login fw-bold text-uppercase" type="submit">
                          <i class="fab fa-google me-2"></i> Registrati con Google
                        </button>
                      </div>
        
                      <div class="d-grid">
                        <button class="btn btn-lg btn-facebook btn-login fw-bold text-uppercase" type="submit">
                          <i class="fab fa-facebook-f me-2"></i> Registrati con Facebook
                        </button>
                      </div>
        
                    </form>
                  </div>

`;

    Swal.fire({
        title: 'Registrati',
        html: html,
        showCloseButton: true,
        showCancelButton: false,
        showConfirmButton: false,
    });
}

// Elimina il colore di default di bootstrap nel dropdown

document.addEventListener('DOMContentLoaded', function() {

    var dropdown_servizi = document.querySelector('.dropdown_servizi');
    var dropdown_items = document.querySelectorAll('.dropdown-item');

    dropdown_items.forEach(function(dropdownItem) {
      dropdownItem.addEventListener('mouseover', function() {
        dropdown_servizi.style.backgroundColor = 'var(--dark-grey)';
      });

      dropdownItem.addEventListener('mouseout', function() {
        dropdown_servizi.style.backgroundColor = "transparent !important";
      });
    });
});

// Elimina il colore di default di bootstrap in Nostri Servizi

document.addEventListener('DOMContentLoaded', function() {

  var nostri_servizi_card = document.querySelectorAll('.nostri_servizi_card');

  nostri_servizi_card.forEach(function(param) {
    param.addEventListener('mouseover', function() {
      var nostri_servizi_testo = param.querySelectorAll('.nostri_servizi_testo');
      nostri_servizi_testo.forEach(function(item) {
        item.style.color = 'var(--dark-grey)';
      });
    });

    param.addEventListener('mouseout', function() {
      var nostri_servizi_testo = param.querySelectorAll('.nostri_servizi_testo');
      nostri_servizi_testo.forEach(function(item) {
        item.style.color = "black";
      });
    });
  });
});


// Carica recensioni



var recensioni = [
  {
    "name": "Paula Verdi",
    "details": "Media Analyst / SkyNet",
    "img": "img/1.jpg",
    "testimonial": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eu sem tempor, varius quam at, luctus dui. Mauris magna metus, dapibus nec turpis vel, semper malesuada ante, commodo iacul viverra.",
    "star-rating": 4.5
  },
  {
    "name": "Antonio Moreno",
    "details": "Web Developer / SoftBee",
    "img": "img/2.jpg",
    "testimonial": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eu sem tempor, varius quam at, luctus dui. Mauris magna metus, dapibus nec turpis vel, semper malesuada ante, commodo iacul viverra.",
    "star-rating": 5
  },
  {
    "name": "Michael Rossi",
    "details": "Web Developer / DevCorp",
    "img": "img/3.jpg",
    "testimonial": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eu sem tempor, varius quam at, luctus dui. Mauris magna metus, dapibus nec turpis vel, semper malesuada ante, commodo iacul viverra.",
    "star-rating": 4.5
  },
  {
    "name": "Maria Santi",
    "details": "Graphic Designer / MarsMedia",
    "img": "img/4.jpg",
    "testimonial": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eu sem tempor, varius quam at, luctus dui. Mauris magna metus, dapibus nec turpis vel, semper malesuada ante, commodo iacul viverra.",
    "star-rating": 4
  },
  {
    "name": "Davide Bianchi",
    "details": "SEO Analyst / RealSearch",
    "img": "img/5.jpg",
    "testimonial": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eu sem tempor, varius quam at, luctus dui. Mauris magna metus, dapibus nec turpis vel, semper malesuada ante, commodo iacul viverra.",
    "star-rating": 4.5
  },
  {
    "name": "Luca Gialli",
    "details": "Web Designer / UniqueDesign",
    "img": "img/6.jpg",
    "testimonial": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eu sem tempor, varius quam at, luctus dui. Mauris magna metus, dapibus nec turpis vel, semper malesuada ante, commodo iacul viverra.",
    "star-rating": 4.5
  }
]

document.addEventListener('DOMContentLoaded', function() {

  
  var recensione_elements = document.querySelectorAll('.recensione');


  // loop per creare ogni singola recensione

  for (let i = 0; i < recensione_elements.length; i++) {
    let recensione = recensione_elements[i];
    let recensioni_oggetto = recensioni[i];

    // Creazione del rating

    let rating = recensioni_oggetto["star-rating"];
    let ratingElement = "";

    switch (rating) {
      case 5:
        ratingElement = `
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
        `;
        break;
      case 4.5:
        ratingElement = `
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-half-o"></i></li>
        `;
        break;
      case 4:
        ratingElement = `
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
        `;
        break;
      case 3.5:
        ratingElement = `
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-half-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
        `;
        break;
      case 3:
        ratingElement = `
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
        `;
        break;
      case 2.5:
        ratingElement = `
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-half-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
        `;
        break;
      case 2:
        ratingElement = `
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
        `;
        break;
      case 1.5:
        ratingElement = `
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-half-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
        `;
        break;
      case 1:
        ratingElement = `
          <li class="list-inline-item"><i class="fa fa-star"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
        `;
        break;
      case 0.5:
        ratingElement = `
          <li class="list-inline-item"><i class="fa fa-star-half-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
          <li class="list-inline-item"><i class="fa fa-star-o"></i></li>
        `;
        break;
      default:
        ratingElement = '';
        break;
    }

    // Assegnazione dei valori e creazione della recensione

    recensione.innerHTML += `
      <div class="testimonial-wrapper">
        <div class="testimonial">${recensioni_oggetto.testimonial}</div>
        <div class="media">
          <div class="media-left d-flex mr-3">
            <img src="${recensioni_oggetto.img}" alt="Immagine di ${recensioni_oggetto.name}">
          </div>
          <div class="media-body">
            <div class="overview">
              <div class="name"><b>${recensioni_oggetto.name}</b></div>
              <div class="details">${recensioni_oggetto.details}</div>
              <div class="star-rating">
                <ul class="list-inline">
                  ${ratingElement}
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    `;
  }
});