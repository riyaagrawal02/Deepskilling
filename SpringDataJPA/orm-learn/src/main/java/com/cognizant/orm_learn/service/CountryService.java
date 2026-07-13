@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public List<Country> search(String text) {
        return repository.findByNameContaining(text);
    }

    public List<Country> searchSorted(String text) {
        return repository.findByNameContainingOrderByNameAsc(text);
    }

    public List<Country> startsWith(String letter) {
        return repository.findByNameStartingWith(letter);
    }
}